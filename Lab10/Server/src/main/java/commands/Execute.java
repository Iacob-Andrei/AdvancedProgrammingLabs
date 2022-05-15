package commands;

import client.ClientState;

import java.util.List;

public interface Execute {
    String executeCommand(List<String> args, ClientState clientState);
}
