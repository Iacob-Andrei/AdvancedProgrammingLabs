package commands;

import client.ClientState;

import java.util.List;

public class ExitCommand implements ExecuteCommand {

    @Override
    public String executeCommand(List<String> args, ClientState clientState) {
        return "exit";
    }

}
