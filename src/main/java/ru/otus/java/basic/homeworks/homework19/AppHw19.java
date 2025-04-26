package ru.otus.java.basic.homeworks.homework19;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class AppHw19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите имя файла: ");
        String fileName = scanner.nextLine();

        System.out.print("Введите искомые символы: ");
        String searchString = scanner.nextLine();

        try {
            String content = Files.readString(Paths.get(fileName), StandardCharsets.UTF_8);

            int count = 0;
            int index = 0;

            while ((index = content.indexOf(searchString, index)) != -1) {
                count++;
                index += searchString.length();
            }

            System.out.println("Количество вхождений: " + count);

        } catch (Exception e) {
            System.out.println("Произошла ошибка: " + e.getMessage());
        }
    }
}