package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager;

import java.io.File;

public class FindCommand implements Command {

    @Override
    public String getName() {
        return "find";
    }

    @Override
    public String getDescription() {
        return "find [filename]             – поиск файла по имени в текущем каталоге или любом его подкаталоге";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("find [filename] – укажите имя файла для поиск");
            return;
        }
        String targetName = args[1];
        File currentDir = FileManager.currentDir;

        System.out.println("Поиск файла \"" + targetName + "\" в каталоге: " + currentDir.getAbsolutePath());
        boolean found = searchRecursive(currentDir, targetName);

        if (!found) {
            System.out.println("Файл \"" + targetName + "\" не найден.");
        }
    }
    private boolean searchRecursive(File dir, String targetName) {
        File[] files = dir.listFiles();
        if (files == null) return false;

        boolean found = false;
        for (File file : files) {
            if (file.getName().equalsIgnoreCase(targetName)) {
                System.out.println("Найден: " + file.getAbsolutePath());
                found = true;
            }
            if (file.isDirectory()) {
                found |= searchRecursive(file, targetName);
            }
        }
        return found;
    }
}

