package ru.otus.java.basic.homeworks.project;

import java.io.File;
import java.util.Scanner;

public class FileManager {
    public static File currentDir = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CommandExecutor executor = new CommandExecutor();

        System.out.println("Консольный файловый менеджер");
        System.out.println("Текущий каталог: " + currentDir.getAbsolutePath());
        System.out.println("Введите 'help' для списка команд.");

        while (true) {
            System.out.print(currentDir.getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();
            if (input.isEmpty()) continue;
            executor.process(input);
        }
    }
}
