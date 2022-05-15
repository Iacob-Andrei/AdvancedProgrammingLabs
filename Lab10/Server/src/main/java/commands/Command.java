package commands;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Command {
    private String name;
    private List<String> commandArgs = new LinkedList<>();

    public Command(String fullCommand) {
        String[] words = fullCommand.split(" ");
        name = words[0];
        commandArgs.addAll(Arrays.asList(words).subList(1, words.length));
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getCommandArgs() {
        return commandArgs;
    }

    public void setCommandArgs(List<String> commandArgs) {
        this.commandArgs = commandArgs;
    }
}
