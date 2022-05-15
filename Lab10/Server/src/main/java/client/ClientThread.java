package client;

import commands.Command;
import commands.CommandList;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;

public class ClientThread extends Thread {

    private final Socket socket;
    public CommandList commands;

    public ClientThread (Socket socket, CommandList commands) {
        this.socket = socket ;
        this.commands = commands;
    }

    public void run () {
        ClientState clientState = new ClientState();
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
            // Send the response to the output stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String request, answer;

            while( (request = in.readLine()) != null ){

                System.out.println("[REQUEST] " + request);

                Command command = new Command(request);
                answer = commands.runCommand(command, clientState);

                if( request.equals("exit") ){
                    System.out.println("Connection closed with the client!");
                    break;
                }

                if(request.equals("stop")){
                    out.println("Server and client stopped");
                    out.flush();
                    socket.close();
                    System.exit(0);

                }

                System.out.println("[RESPONSE] " + answer);
                List<String> responseLines = List.of(answer.split("\n"));

                for (String line : responseLines) {
                    out.println(line);
                    out.flush();
                    System.out.println("[SENT] " + line);
                }

                out.println("");
                out.flush();

                socket.setSoTimeout(20_000);
            }
        } catch(SocketException e){
            System.err.println("User " + clientState.getUserName() + " has timed out!");
        }
        catch (IOException e) {
            System.err.println("Communication error... " + e);
        }finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}