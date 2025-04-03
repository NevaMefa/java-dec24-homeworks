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
    private boolean authenticated;
    private String role = "USER";


    public ClientHand(Socket socket, Server server) throws IOException {
        this.socket = socket;
        this.server = server;
        this.in = new DataInputStream(socket.getInputStream());
        this.out = new DataOutputStream(socket.getOutputStream());
        if (this.role == null) {
            this.role = "USER";
        }
        new Thread(() -> {
            try {
                System.out.println("Клиент подключился");
                //цикл аутентификации
                while (true) {
                    sendMsg("Перед работой с чатом необходимо выполнить аутентификацию " +
                            "/auth login password \n" +
                            "или регистрацию /reg login password username");
                    String message = in.readUTF();
                    if (message.startsWith("/")) {
                        if (message.equals("/exit")) {
                            sendMsg("/exitok");
                            break;
                        }
                        if (message.startsWith("/auth ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 3) {
                                sendMsg("Неверный формат команды /auth ");
                                continue;
                            }
                            if (server.getAuthenticatedProvider().authenticate(
                                    this, elements[1], elements[2])) {
                                authenticated = true;
                                break;
                            }
                        }
                        if (message.startsWith("/reg ")) {
                            String[] elements = message.split(" ");
                            if (elements.length != 4) {
                                sendMsg("Неверный формат команды /reg ");
                                continue;
                            }
                            if (server.getAuthenticatedProvider().registration(
                                    this, elements[1], elements[2], elements[3])) {
                                authenticated = true;
                                break;
                            }
                        }
                    }
                }

                while (authenticated) {
                    try {
                        String message = in.readUTF();
                        if (message.startsWith("/")) {
                            if (message.startsWith("/kick ")) {
                                System.out.println("Команда /kick получена: " + message);
                                if (!role.equals("ADMIN")) {
                                    sendMsg("Ошибка! У вас нет прав на использование этой команды");
                                    continue;
                                }
                                String[] tokens = message.split(" ");
                                if (tokens.length != 2) {
                                    sendMsg("Ошибка! Используйте формат: /kick <ник>");
                                    continue;
                                }

                                String targetUsername = tokens[1];
                                boolean success = server.kickUser(targetUsername, this);
                                if (success) {
                                    sendMsg("Пользователь " + targetUsername + " был отключен.");
                                } else {
                                    sendMsg("Ошибка! Пользователь " + targetUsername + " не найден.");
                                }
                            }
                            if (message.equals("/exit")) {
                                sendMsg("/exitok");
                                break;
                            } else if (message.startsWith("/w ")) {
                                handlePrivateMessage(message);
                            }
                        } else {
                            server.broadcastMessage(username + ": " + message, this);
                        }
                    } catch (IOException e) {
                        System.out.println("Соединение с клиентом разорвано.");
                        break;
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

    public void setUsername(String username) {
        this.username = username;
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
            if (socket != null && !socket.isClosed()) {
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
