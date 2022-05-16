package server;

import commands.*;
import client.ClientThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static final int PORT = 8100;

    public SimpleServer() {

        CommandList commandList = new CommandList();
        commandList.add("register", new RegisterCommand());
        commandList.add("login", new LoginCommand());
        commandList.add("friend", new AddFriendCommand());
        commandList.add("send", new SendCommand());
        commandList.add("read", new ReadCommand());
        commandList.add("logout", new LogoutCommand());
        commandList.add("seeUsers", new SeeUsersCommand());
        commandList.add("createSVG", new CreateSVGCommand());
        commandList.add("createHTML", new CreateHTMLCommand());
        commandList.add("proprieties", new SocialPropertiesCommand());
        commandList.add("flow",new MaximumFlowCommand());

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            while (true) {
                System.out.println("[WAITING FOR CLIENT...]");
                Socket socket = serverSocket.accept();
                ClientThread client = new ClientThread(socket, commandList);
                new Thread(client).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
