package commands;

import client.ClientState;

import java.util.HashMap;
import java.util.Map;

public class CommandList {

    private Map<String, ExecuteCommand> commands = new HashMap<>();

    public void add(String name, ExecuteCommand executeCommand) {

        if (name != null)
            commands.put(name, executeCommand);
    }

    public String runCommand(Command command, ClientState clientState) {

        ExecuteCommand executable = commands.get(command.getName());

        if (executable != null)
            return executable.executeCommand(command.getCommandArgs(), clientState);

        return "Command is invalid";
    }
}
