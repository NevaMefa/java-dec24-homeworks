package ru.otus.java.basic.homeworks.homework17.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class ClientHand {
    private Socket socket;
    private Server server;
    private DataInputStream in;
    private DataOutputStream out;
    private String username;

    public ClientHand(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());

        new Thread(() -> {
            try {
                System.out.println("Клиент подключился");

                // Получаем имя пользователя
                username = in.readUTF().trim();
                if (username.isEmpty()) {
                    username = "User" + (server.getClients().size() + 1);
                }

                server.subscribe(this);

                while (true) {
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMsg("/exitok");
                            break;
                        } else if (message.startsWith("/w ")) {
                            handlePrivateMessage(message);
                        }
                    } else {
                        server.broadcastMessage(username + ": " + message, this);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                disconnect();
            }
        }).start();
    }

    private void handlePrivateMessage(String message) {
        String[] tokens = message.split(" ", 3);
        if (tokens.length < 3) {
            sendMsg("Ошибка! Используйте формат: /w <ник> <сообщение>");
            return;
        }

        String recipient = tokens[1].trim();
        String privateMessage = tokens[2].trim();

        boolean found = false;
        for (ClientHand client : server.getClients()) {
            if (client.getUsername().equals(recipient)) {
                client.sendMsg("(ЛС от " + username + "): " + privateMessage);
                sendMsg("(ЛС для " + recipient + "): " + privateMessage);
                found = true;
                break;
            }
        }

        if (!found) {
            sendMsg("Пользователь " + recipient + " не найден.");
        }
    }

    public void sendMsg(String message) {
        try {
            out.writeUTF(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }

    public void disconnect() {
        server.unsubscribe(this);
        try {
            if (in != null) {
                in.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            if (out != null) {
                out.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        try {
            if (socket != null) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
