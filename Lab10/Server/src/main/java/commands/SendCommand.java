package commands;

import client.ClientState;
import server.Info;

import java.util.List;
import java.util.Set;

public class SendCommand implements Execute{
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {
        if (args.size() == 0)
            return "please provide an message";

        Set<String> clientFriends = Info.getFriends().get(clientState.getUserName());

        StringBuilder message = new StringBuilder(" ");
        for (String item : args)
            message.append(item).append(" ");

        message = new StringBuilder(message.substring(0, message.length() - 1));
        System.out.println("[MESSAGE] " + message);

        StringBuilder result = new StringBuilder();
        for (String friend : clientFriends)
            result.append(Info.sendMessage(friend, message.toString())).append("\n");

        return result.toString();
    }
}
