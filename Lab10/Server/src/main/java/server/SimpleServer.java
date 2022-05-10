package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {

    public static final int PORT = 8100;

    public SimpleServer() throws IOException {
        ServerSocket serverSocket = null ;
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println ("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                // Execute the client's request in a new thread
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err. println ("Ooops... " + e);
        } finally {
            assert serverSocket != null;
            serverSocket.close();
        }
    }
}
