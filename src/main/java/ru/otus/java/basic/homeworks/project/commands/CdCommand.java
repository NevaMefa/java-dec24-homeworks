package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager;

import java.io.File;

public class CdCommand implements Command {
    @Override
    public String getName() {
        return "cd";
    }

    @Override
    public String getDescription() {
        return "cd [path]                   - перейти в указанный каталог (cd .. — вверх)";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите путь для перехода (например, cd папка)");
            return;
        }

        String pathArg = args[1];

        if (pathArg.matches(".*[<>:\"/\\\\|?*].*")) {
            System.out.println("Ошибка: путь содержит недопустимые символы.");
            return;
        }

        File newDir = pathArg.equals("..") ? FileManager.currentDir.getParentFile()
                : new File(FileManager.currentDir, pathArg);

        if (newDir != null && newDir.exists() && newDir.isDirectory()) {
            FileManager.currentDir = newDir;
            System.out.println("Перешли в каталог: " + FileManager.currentDir.getAbsolutePath());
        } else {
            System.out.println("Каталог не найден: " + pathArg);
        }
    }
}
