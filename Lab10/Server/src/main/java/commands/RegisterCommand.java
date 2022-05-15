package commands;

import client.ClientState;
import server.Info;

import java.util.List;

public class RegisterCommand  implements Execute{
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {
        if (args.size() == 0)
            return "Please provide userName";

        if (clientState.isLoggedIn())
            return "you are already logged in.";

        return Info.addUser(args.get(0));
    }
}
