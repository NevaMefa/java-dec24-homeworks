package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.FileManager;

import java.io.File;

public class RmCommand implements Command {
    @Override
    public String getName() {
        return "rm";
    }

    @Override
    public String getDescription() {
        return "rm [name]                   - удаление файла или директории (в т.ч. непустых)";
    }

    @Override
    public void execute(String[] args) {
        if (args.length < 2) {
            System.out.println("Укажите имя файла или директории для удаления (например, rm файл.txt)");
            return;
        }

        String name = args[1];

        if (name.matches(".*[<>:\"/\\\\|?*].*")) {
            System.out.println("Ошибка: путь содержит недопустимые символы.");
            return;
        }

        File target = new File(FileManager.currentDir, name);

        if (!target.exists()) {
            System.out.println("Файл или директория не найдены: " + name);
            return;
        }

        boolean success = target.isDirectory() ? deleteDirectoryRecursively(target) : target.delete();

        if (success) {
            System.out.println("Успешно удалено: " + target.getName());
        } else {
            System.out.println("Не удалось удалить: " + target.getName());
        }
    }

    private boolean deleteDirectoryRecursively(File dir) {
        File[] contents = dir.listFiles();
        if (contents != null) {
            for (File file : contents) {
                if (file.isDirectory()) {
                    if (!deleteDirectoryRecursively(file)) return false;
                } else {
                    if (!file.delete()) return false;
                }
            }
        }
        return dir.delete();
    }
}
