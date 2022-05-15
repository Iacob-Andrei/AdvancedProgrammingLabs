package commands;

import client.ClientState;
import server.Info;

import java.util.List;

public class SeeUsersCommand implements ExecuteCommand{
    @Override
    public String executeCommand(List<String> args, ClientState clientState) {
      List<String> users = Info.getUsers();
        StringBuilder existingUsers = new StringBuilder();
        for(String user:users){
            existingUsers.append(user).append("\n");
        }
        return existingUsers.toString();
    }
}
