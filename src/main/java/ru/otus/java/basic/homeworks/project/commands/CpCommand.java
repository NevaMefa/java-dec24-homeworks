package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager1;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class CpCommand implements Command {
    @Override
    public String getName() {
        return "cp";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 3) {
            System.out.println("Нужно указать исходное и конечное место: cp [источник] [назначение]");
            return;
        }

        boolean force = args.length > 3 && args[3].equals("-f");
        File source = new File(FileManager1.currentDir, args[1]);
        File dest = new File(FileManager1.currentDir, args[2]);

        if (!source.exists()) {
            System.out.println("Источник не найден: " + args[1]);
            return;
        }

        if (dest.exists() && !force) {
            System.out.println("Файл назначения уже существует, используйте -f для перезаписи");
            return;
        }

        try {
            Files.copy(source.toPath(), dest.toPath(), StandardCopyOption.REPLACE_EXISTING);
            System.out.println("Файл скопирован");
        } catch (IOException e) {
            System.out.println("Ошибка копирования: " + e.getMessage());
        }
    }
}

