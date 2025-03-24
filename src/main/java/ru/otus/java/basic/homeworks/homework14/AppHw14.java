package ru.otus.java.basic.homeworks.homework14;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AppHw14 {
    public static void main(String[] args) {
        for (File file : new File(".").listFiles()) {
            if (file.isFile() && file.getName().endsWith(".txt")) {
                System.out.println(file.getName());
            }
        }

        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя файла ");
        String fileName = scanner.nextLine();
        System.out.println("Вы выбрали " + fileName);
        try (FileInputStream in = new FileInputStream(fileName)) {
            int n = in.read();
            do {
                System.out.print((char) n);
                n = in.read();
            } while (n != -1);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.print("Введите строку для записи в файл: ");
        String userText = scanner.nextLine();

        File file = new File(fileName);

        try (FileWriter writer = new FileWriter(file, true)) {
            writer.write(" " + userText);
            System.out.println("Строка успешно записана.");
        } catch (IOException e) {
            System.out.println("Ошибка записи: " + e.getMessage());
        }
    }
}