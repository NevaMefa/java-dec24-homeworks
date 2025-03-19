package ru.otus.java.basic.homeworks.homework15.client;

import ru.otus.java.basic.homeworks.homework15.util.ExampleClient;

import javax.imageio.IIOException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static voi1d main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try (Socket socket = new Socket("localhost", 8080)) {
                ExampleClient client = new ExampleClient(socket.getInputStream(),
                        socket.getOutputStream());

                System.out.println("Выберите операцию: 1 - + , 2 - -, 3 - *, 4 - /");
                String userMessage = scanner.nextLine();

                if (userMessage.equalsIgnoreCase("exit")) {
                    client.send(userMessage);
                    break;
                }

                client.send(userMessage);
                System.out.println("Введите первое число: ");
                String num1 = scanner.nextLine();
                client.send(num1);
                System.out.println("Введите второе число: ");
                String num2 = scanner.nextLine();
                client.send(num2);

                String result = client.receive();
                System.out.println("Результат от сервера: " + result);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}