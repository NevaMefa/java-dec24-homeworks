package ru.otus.java.basic.homeworks.project;

import ru.otus.java.basic.homeworks.project.commands.*;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CommandExecutor {
    private final Map<String, Command> commands = new TreeMap<>();

    public CommandExecutor() {
        register(new LsCommand());
        register(new CdCommand());
        register(new FindCommand());
        register(new MkdirCommand());
        register(new RmCommand());
        register(new CpCommand());
        register(new MvCommand());
        register(new FinfoCommand());
        register(new HelpCommand(this));
        register(new ExitCommand());

    }

    private void register(Command command) {
        commands.put(command.getName(), command);
    }

    public void process(String input) {
        String[] parts = input.split("\\s+");
        String commandName = parts[0];

        Command command = commands.get(commandName);
        if (command != null) {
            command.execute(parts);
        } else {
            System.out.println("Неизвестная команда: " + commandName);
        }
    }

    public Iterable<String> getAvailableCommandNames() {
        return commands.keySet();
    }
    public Iterable<Command> getAllCommands() {
        return commands.values();
    }
}

