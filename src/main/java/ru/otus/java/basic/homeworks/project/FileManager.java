package ru.otus.java.basic.homeworks.project;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
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
            case "rm":
                rm(parts);
                break;
            case "mv":
                mv(parts);
                break;
            case "cp":
                cp(parts);
                break;
            default:
                System.out.println("Неизвестная команда: " + command);
        }
    }

    private static boolean containsInvalidChars(String name) {
        return name.matches(".*[<>:\"/\\\\|?*].*");
    }

    private static void help() {
        System.out.println("Доступные команды:");
        System.out.println("ls [-i]          - список файлов в текущем каталоге");
        System.out.println("cd [path]        - перейти в указанный каталог (cd .. — вверх)");
        System.out.println("mv [source] [destination] [-f]     - переименовать/перенести файл или директорию, -f для перезаписи уже существующего");
        System.out.println("cp [source] [destination] [-f]     - скопировать файл, -f для перезаписи уже существующего");
        System.out.println("mkdir [name]     - создание новой директории");
        System.out.println("help             - список команд");
        System.out.println("rm [name]        - удаление файла или директории (в т.ч. непустых)");
        System.out.println("exit             - выход из программы");
    }

    private static void cp(String[] args) {
        if (args.length < 3) {
            System.out.println("Нужно указать исходное и конечное место: mv [истоник] [назначение]");
            return;
        }
        boolean force = false;
        if (args.length > 3 && args[3].equals("-f")) {
            force = true;
        }

        File source = new File(currentDir, args[1]);
        File dest = new File(currentDir, args[2]);

        if (!source.exists()) {
            System.out.println("Источник не найден: " + args[1]);
            return;
        }

        if (dest.exists() && !force) {
            System.out.println("Файл назначения уже существует, используйте -f для перезаписи: ");
            return;
        }

        try {
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл скопирован");
        } catch (IOException e) {
            System.out.println("Ошибка копирования: " + e.getMessage());
        }
    }

    private static void mv(String[] args) {
        if (args.length < 3) {
            System.out.println("Нужно указать исходный и целевой путь: mv [истоник] [назначение]");
            return;
        }


        String sourceName = args[1];
        String destName = args[2];

        if (containsInvalidChars(sourceName) || containsInvalidChars(destName)) {
            System.out.println("Ошибка: имя содержит недопустимые символы.");
            return;
        }
        boolean force = false;
        if (args.length > 3 && args[3].equals("-f")) {
            force = true;
        }

        File source = new File(currentDir, sourceName);
        File dest = new File(currentDir, destName);

        if (!source.exists()) {
            System.out.println("Источник не найден: " + sourceName);
            return;
        }

        if (!dest.exists() && !force) {
            System.out.println("Файл  или папка уже существуют: " + destName);
            System.out.println("Используйте ключ -f для перезаписи");
            return;
        }

        boolean success = source.renameTo(dest);
        if (success) {
            System.out.println("Успешно перемещено/переименовано " + sourceName + " -> " + destName);
        } else {
            System.out.println("Не удалось переместить/переименовать" + sourceName);
        }
    }

    private static void rm(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите имя файла или директории для удаления (например, rm файл.txt)");
            return;
        }

        String name = args[1];

        if (containsInvalidChars(name)) {
            System.out.println("Ошибка: имя содержит недопустимые символы.");
            return;
        }

        File target = new File(currentDir, name);

        if (!target.exists()) {
            System.out.println("Файл  или директория не найдены: " + name);
            return;
        }

        boolean success;
        if (target.isDirectory()) {
            success = deleteDirectoryRecursively(target);
        } else {
            success = target.delete();
        }

        if (success) {
            System.out.println("Успешно удалено: " + target.getName());
        } else {
            System.out.println("Не удалось удалить: " + target.getName());
        }

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

        if (containsInvalidChars(pathArg)) {
            System.out.println("Ошибка: имя содержит недопустимые символы.");
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

        if (containsInvalidChars(dirName)) {
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

    private static boolean deleteDirectoryRecursively(File dir) {
        File[] allContents = dir.listFiles();
        if (allContents != null) {
            for (File file : allContents) {
                if (file.isDirectory()) {
                    if (!deleteDirectoryRecursively(file)) {
                        return false;
                    }
                } else {
                    if (!file.delete()) {
                        return false;
                    }
                }
            }
        }
        return dir.delete();
    }
}