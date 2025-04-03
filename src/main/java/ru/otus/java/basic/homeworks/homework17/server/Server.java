package ru.otus.java.basic.homeworks.homework17.server;


import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Server {
    private int port;
    private List<ClientHand> clients;
    private AuthenticatedProvider authenticatedProvider;

    public Server(int port) {
        this.port = port;
        clients = new CopyOnWriteArrayList<>();
        authenticatedProvider = new InMemoryAuthenticatedProvider(this);
    }

    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту " + port);
            authenticatedProvider.initialize();

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

    public boolean isUsernameBusy(String username) {
        for (ClientHand client : clients) {
            if (client.getUsername().equals(username)) {
                return true;
            }
        }
        return false;
    }

    public AuthenticatedProvider getAuthenticatedProvider() {
        return authenticatedProvider;
    }

    public boolean kickUser(String username, ClientHand admin) {
        System.out.println("Попытка отключить пользователя: " + username);

        System.out.println("Текущие клиенты:");
        for (ClientHand client : clients) {
            System.out.println(" - " + client.getUsername());
        }

        ClientHand clientToKick = null;

        if (username.equals(admin.getUsername())) {
            System.out.println("Администратор не может кикнуть самого себя.");
            admin.sendMsg("Вы не можете кикнуть самого себя.");
            return false;
        }

        for (ClientHand client : clients) {
            if (client.getUsername().equals(username)) {
                System.out.println("Найден пользователь для отключения: " + username);
                client.sendMsg("/kicked");
                client.sendMsg("Вы были отключены администратором " + admin.getUsername());
                clientToKick = client;
                break;
            }
        }

        if (clientToKick != null) {
            System.out.println("Отключаем пользователя: " + clientToKick.getUsername());
            clientToKick.disconnect();
            clients.remove(clientToKick);
            broadcastMessage("Пользователь " + username + " был кикнут администратором.", null);
            return true;
        }

        System.out.println("Ошибка! Пользователь " + username + " не найден.");
        return false;
    }
}

