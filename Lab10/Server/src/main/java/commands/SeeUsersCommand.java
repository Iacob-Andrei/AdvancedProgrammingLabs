package commands;

import client.ClientState;
import server.Info;

import java.util.List;

public class SeeUsersCommand implements ExecuteCommand{
    /**
     * @return shows all the users from users.txt
     */
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
