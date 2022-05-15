package commands;

import client.ClientState;

import java.util.List;

public class LogoutCommand implements ExecuteCommand {
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {

        if (clientState.isLoggedIn()) {
            clientState.setLoggedIn(false);
            clientState.setUserName(null);
            return "user logged out";
        }
        return "you are not logged in";
    }
}

