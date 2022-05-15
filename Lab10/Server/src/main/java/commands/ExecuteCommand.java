package commands;

import client.ClientState;

import java.util.List;

public interface ExecuteCommand {
    String executeCommand(List<String> args, ClientState clientState);
}
