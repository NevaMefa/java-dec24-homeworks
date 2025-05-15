package ru.otus.java.basic.homeworks.project;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class FileManager {
    private static File currentDir = new File(System.getProperty("user.dir"));

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Консольный файловый менеджер");
        System.out.println("Текущий каталог: " + currentDir.getAbsolutePath());
        System.out.println("Введите 'help' для списка команд.");

        while (true) {
            System.out.print(currentDir.getAbsolutePath() + " > ");
            String input = scanner.nextLine().trim();

            if (input.equals("exit")) {
                System.out.println("Завершение работы.");
                break;
            }

            processCommand(input);
        }
    }

    private static void processCommand(String input) {
        String[] parts = input.split("\\s+");
        String command = parts[0];

        switch (command) {
            case "ls":
                ls(parts);
                break;
            case "cd":
                cd(parts);
                break;
            case "help":
                help();
                break;
            case "mkdir":
                mkdir(parts);
                break;
            default:
                System.out.println("Неизвестная команда: " + command);
        }
    }

    private static void help() {
        System.out.println("Доступные команды:");
        System.out.println("ls [-i]          - список файлов в текущем каталоге");
        System.out.println("cd [path]        - перейти в указанный каталог (cd .. — вверх)");
        System.out.println("mkdir [name]     - создание новой директории");
        System.out.println("help             - список команд");
        System.out.println("exit             - выход из программы");
    }

    private static void ls(String[] args) {
        File[] files = currentDir.listFiles();
        if (files == null) {
            System.out.println("Ошибка чтения каталога.");
            return;
        }

        boolean detailed = args.length > 1 && args[1].equals("-i");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm");

        for (File file : files) {
            if (detailed) {
                String name = file.getName();
                String size = file.isFile() ? (file.length() + " bytes") : "<DIR>";
                String lastMod = sdf.format(new Date(file.lastModified()));
                System.out.printf("%-30s %-10s %s\n", name, size, lastMod);
            } else {
                System.out.println(file.getName());
            }
        }
    }

    private static void cd(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите путь для перехода (например, cd папка)");
            return;
        }

        String pathArg = args[1];

        if (pathArg.matches(".*[<>:\"/\\\\|?*].*")) {
            System.out.println("Ошибка: путь содержит недопустимые символы.");
            return;
        }

        File newDir;
        if (pathArg.equals("..")) {
            newDir = currentDir.getParentFile();
        } else {
            newDir = new File(currentDir, pathArg);
        }

        if (newDir != null && newDir.exists() && newDir.isDirectory()) {
            currentDir = newDir;
            System.out.println("Перешли в каталог: " + currentDir.getAbsolutePath());
        } else {
            System.out.println("Каталог не найден: " + pathArg);
            System.out.println("Возможные каталоги:");
            File[] subdirs = currentDir.listFiles(File::isDirectory);
            if (subdirs != null) {
                for (File dir : subdirs) {
                    System.out.println("  - " + dir.getName());
                }
            }
        }
    }

    private static void mkdir(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите имя директории для создания (например, mkdir папка)");
            return;
        }

        String dirName = args[1];

        if (dirName.matches(".*[<>:\"/\\\\|?*].*")) {
            System.out.println("Ошибка: имя содержит недопустимые символы.");
            return;
        }

        File newDir = new File(currentDir, dirName);
        if (newDir.exists()) {
            System.out.println("Директория уже существует: " + dirName);
            return;
        }

        if (newDir.mkdir()) {
            System.out.println("Директория создана: " + newDir.getAbsolutePath());
        } else {
            System.out.println("Не удалось создать директорию: " + dirName);
        }
    }
}