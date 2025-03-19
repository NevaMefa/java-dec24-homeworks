package ru.otus.java.basic.homeworks.homework15.server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(8080);
        System.out.println("SERVER START!");

        while (true) {
            try (Socket client = socket.accept();
                 DataInputStream inputStream = new DataInputStream(client.getInputStream());
                 DataOutputStream outputStream = new DataOutputStream(client.getOutputStream())) {

                System.out.println("client.getPort() = " + client.getPort());

                String userInput = inputStream.readUTF();
                System.out.println("получили от пользователя : " + userInput);

                if (userInput.equalsIgnoreCase("exit")) {
                    System.out.println("Клиент с портом :" + client.getPort() + " отключился!");
                    continue;
                }
                String num1 = inputStream.readUTF();
                String num2 = inputStream.readUTF();
                System.out.println("Получены числа: " + num1 + " и " + num2);
                String result = calculate(userInput, num1, num2);
                System.out.println(result);
                outputStream.writeUTF(result);
                outputStream.flush();

            } catch (IOException e) {
                System.out.println("Ошибка при обработке клиента: " + e.getMessage());
            }
        }
    }

    public static String calculate(String operation, String num1, String num2) {
        try {
            double n1 = Double.parseDouble(num1);
            double n2 = Double.parseDouble(num2);
            System.out.println("Операция: " + operation + ", Число 1: " + n1 + ", Число 2: " + n2);
            if (operation.equals("1")) {
                return "Результат: " + (n1 + n2);
            } else if (operation.equals("2")) {
                return "Результат: " + (n1 - n2);
            } else if (operation.equals("3")) {
                return "Результат: " + (n1 * n2);
            } else if (operation.equals("4")) {
                return n2 != 0 ? "Результат: " + (n1 / n2) : "Ошибка: Деление на ноль!";
            } else {
                return "Ошибка: Некорректная операция. Введите 1, 2, 3 или 4.";
            }
        } catch (NumberFormatException e) {
            return "Ошибка: Введите корректные числа.";
        }
    }
}