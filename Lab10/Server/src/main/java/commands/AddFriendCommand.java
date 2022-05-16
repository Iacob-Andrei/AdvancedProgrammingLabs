package commands;

import client.ClientState;
import server.Info;

import java.util.List;

public class AddFriendCommand implements ExecuteCommand {

    /**
     * @param args the arguments from the command
     * @param clientState checks if the user is logged in or not
     * @return the method adds the friendship in friends.txt
     */
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {

        if (args.size() == 0)
            return "please provide a friend name.";

        if (!clientState.isLoggedIn())
            return "Please login first.";

        String from = clientState.getUserName();

        StringBuilder result = new StringBuilder();
        for (String newFriend : args)
            result.append(Info.addFriend(from, newFriend)).append("\n");

        if (result.length() > 0)
            result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();
    }
}

