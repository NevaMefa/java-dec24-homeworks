package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;

public class ExitCommand implements Command {
    @Override
    public String getName() {
        return "exit";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Завершение работы.");
        System.exit(0);
    }
}
