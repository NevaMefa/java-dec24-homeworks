package ru.otus.java.basic.homeworks.project.commands;

import ru.otus.java.basic.homeworks.project.Command;
import ru.otus.java.basic.homeworks.project.CommandExecutor;

public class HelpCommand implements Command {
    private final CommandExecutor executor;

    public HelpCommand(CommandExecutor executor) {
        this.executor = executor;
    }

    @Override
    public String getName() {
        return "help";
    }

    @Override
    public void execute(String[] args) {
        System.out.println("Доступные команды:");
        for (Command command : executor.getAllCommands()) {
            System.out.println(" - " + command.getDescription());
        }
    }

    @Override
    public String getDescription() {
        return "help                        - список команд";
    }
}
