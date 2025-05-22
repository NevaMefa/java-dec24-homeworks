package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager;

import java.io.File;

public class MkdirCommand implements Command {
    @Override
    public String getName() {
        return "mkdir";
    }

    @Override
    public String getDescription() {
        return "mkdir [name]                - создание новой директории";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите имя директории для создания (например, mkdir папка)");
            return;
        }

        String dirName = args[1];

        if (dirName.matches(".*[<>:\"/\\\\|?*].*")) {
            System.out.println("Ошибка: имя содержит недопустимые символы.");
            return;
        }

        File newDir = new File(FileManager.currentDir, dirName);
        if (newDir.exists()) {
            System.out.println("Директория уже существует: " + dirName);
        } else if (newDir.mkdir()) {
            System.out.println("Директория создана: " + newDir.getAbsolutePath());
        } else {
            System.out.println("Не удалось создать директорию: " + dirName);
        }
    }
}
