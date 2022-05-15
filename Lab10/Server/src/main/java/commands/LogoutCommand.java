package commands;

import client.ClientState;

import java.util.List;

public class LogoutCommand implements Execute{
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {
        if (clientState.isLoggedIn()) {
            clientState.setLoggedIn(false);
            return "user logged out";
        }

        return "you are not logged in";
    }
    }

