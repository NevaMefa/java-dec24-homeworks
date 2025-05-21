package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager1;

import java.io.File;

public class FinfoCommand implements Command {

    @Override
    public String getName() {
        return "finfo";
    }

    @Override
    public String getDescription() {
        return "finfo [filename]            – получить подробную информацию о файле";
    }
    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите имя файла: finfo [filename]");
            return;
        }

        File file = new File(FileManager1.currentDir, args[1]);
        if (!file.exists()) {
            System.out.println("Файл не найден: " + args[1]);
            return;
        }

        System.out.println("Информация о файле: ");
        System.out.println("Имя: " + file.getName());
        System.out.println("Путь: " + file.getAbsolutePath());
        System.out.println("Размер: " + file.length() + " ");
        System.out.println("Директория: " + file.isDirectory());
        System.out.println("Возможность чтения: " + file.canRead());
        System.out.println("Возможность записи " + file.canWrite());
        System.out.println("Возможность выполнения " + file.canExecute());
    }

}
