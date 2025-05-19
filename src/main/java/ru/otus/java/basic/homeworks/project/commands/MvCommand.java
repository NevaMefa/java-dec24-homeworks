package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager1;

import java.io.File;

public class MvCommand implements Command {
    @Override
    public String getName() {
        return "mv";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Нужно указать исходный и целевой путь: mv [источник] [назначение]");
            return;
        }

        String sourceName = args[1];
        String destName = args[2];

        if (sourceName.matches(".*[<>:\"/\\\\|?*].*") || destName.matches(".*[<>:\"/\\\\|?*].*")) {
            System.out.println("Ошибка: имя содержит недопустимые символы.");
            return;
        }

        boolean force = args.length > 3 && args[3].equals("-f");

        File source = new File(FileManager1.currentDir, sourceName);
        File dest = new File(FileManager1.currentDir, destName);

        if (!source.exists()) {
            System.out.println("Источник не найден: " + sourceName);
            return;
        }

        if (dest.exists() && !force) {
            System.out.println("Файл или папка уже существуют: " + destName);
            System.out.println("Используйте ключ -f для перезаписи");
            return;
        }

        boolean success = source.renameTo(dest);
        if (success) {
            System.out.println("Успешно перемещено/переименовано " + sourceName + " -> " + destName);
        } else {
            System.out.println("Не удалось переместить/переименовать " + sourceName);
        }
    }
}
