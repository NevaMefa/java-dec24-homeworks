package ru.otus.java.basic.homeworks.homework17.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHand> clients;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);

            while (true) {
                Socket socket = serverSocket.accept();
                new ClientHand(socket, this);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void subscribe(ClientHand clientHandler) {
        clients.add(clientHandler);
        broadcastMessage(clientHandler.getUsername() + " вошел в чат.", null);
    }

    public void unsubscribe(ClientHand clientHandler) {
        clients.remove(clientHandler);
        System.out.println("Клиент " + clientHandler.getUsername() + " отключился");
        broadcastMessage(clientHandler.getUsername() + " покинул чат.", null);
    }

    public void broadcastMessage(String message, ClientHand sender) {
        for (ClientHand client : clients) {
            if (client != sender) {
                client.sendMsg(message);
            }
        }
    }

    public List<ClientHand> getClients() {
        return clients;
    }

}

