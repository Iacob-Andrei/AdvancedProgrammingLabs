package commands;

import client.ClientState;
import server.Info;

import java.util.List;

public class LoginCommand implements ExecuteCommand {

    @Override
    public String executeCommand(List<String> args, ClientState clientState) {

        List<String> users = Info.getUsers();

        if (args.size() == 0)
            return "Please provide an username.";

        if (clientState.isLoggedIn())
            return "already logged in";

        if (users.contains(args.get(0))) {
            clientState.setLoggedIn(true);
            clientState.setUserName(args.get(0));
            return "logged in";
        }

        return "Logged in failed. User does not exists.";
    }
}

