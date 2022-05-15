package commands;

import client.ClientState;
import server.Info;

import java.util.List;

public class ReadCommand implements ExecuteCommand {

    @Override
    public String executeCommand(List<String> args, ClientState clientState) {

        if (!clientState.isLoggedIn())
            return "Please login first";

        return Info.getMessages(clientState.getUserName());
    }
}

