package ru.otus.java.basic.homeworks.homework22;

import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {
    private int port;
    private Dispatcher dispatcher;

    public HttpServer(int port) {
        this.port = port;
        this.dispatcher = new Dispatcher();
    }


    public void start() {
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            System.out.println("Сервер запущен на порту: " + port);
            while (true) {
                Socket socket = serverSocket.accept();
                new Thread(() -> handleClient(socket)).start(); // 💥 Поток на каждый запрос
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void handleClient(Socket socket) {
        try (socket) {
            byte[] buffer = new byte[8192];
            int n = socket.getInputStream().read(buffer);
            if (n < 0) {
                System.out.println("Получено битое сообщение");
                return;
            }
            String rawRequest = new String(buffer, 0, n);
            HttpRequest request = new HttpRequest(rawRequest);
            request.info(true);
            OutputStream out = socket.getOutputStream();
            dispatcher.execute(request, out);
        } catch (Exception e) {
            System.out.println("Ошибка при обработке запроса: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
