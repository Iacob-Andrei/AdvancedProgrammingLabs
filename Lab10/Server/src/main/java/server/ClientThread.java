package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

class ClientThread extends Thread {

    private final Socket socket;

    public ClientThread (Socket socket) {
        this.socket = socket ;
    }

    public void run () {
        try {
            // Get the request from the input stream: client → server
            BufferedReader in = new BufferedReader( new InputStreamReader(socket.getInputStream()) );
            // Send the response to the output stream: server → client
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String request, answer;

            while( (request = in.readLine()) != null ){

                System.out.println("[REQUEST] " + request);
                answer = "Hello " + request + "!";
                out.println(answer);
                out.flush();
            }

        } catch (IOException e) {
            System.err.println("Communication error... " + e);
        }finally {
            try {
                socket.close(); // or use try-with-resources
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}