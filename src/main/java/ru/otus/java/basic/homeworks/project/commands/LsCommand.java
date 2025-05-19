package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager1;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LsCommand implements Command {
    @Override
    public String getName() {
        return "ls";
    }

    @Override
    public void execute(String[] args) {
        File[] files = FileManager1.currentDir.listFiles();
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
}
