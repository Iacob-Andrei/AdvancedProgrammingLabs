package commands;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Command {
    private String name;
    private List<String> commandArgs = new LinkedList<>();

    public Command(String fullCommand) {
        String[] words = fullCommand.split(" ", 2);
        name = words[0];
        commandArgs.addAll(Arrays.asList(words).subList(1, words.length));
    }

    public String getName() {
        return name;
    }

    public List<String> getCommandArgs() {
        return commandArgs;
    }
}
