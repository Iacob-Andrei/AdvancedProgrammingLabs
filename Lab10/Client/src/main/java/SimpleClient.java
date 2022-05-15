import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.SocketException;

public class SimpleClient {

    public String serverAddress ;
    public int PORT;

    public SimpleClient(String serverAddress, int PORT){
        this.serverAddress = serverAddress;
        this.PORT = PORT;
    }

    public void showCommands() {
        System.out.println("These are the valid commands:");
        System.out.println("1. Register - register <username>");
        System.out.println("2. Login - login <username>");
        System.out.println("3. See all the users - seeUsers");
        System.out.println("4. Add Friend (Needs to be registered!)- friend <friend_username>");
        System.out.println("5. Send message to all friends - send <message>");
        System.out.println("6. Read all the messages - read");
        System.out.println("7. Logout - logout <username>");
        System.out.println("8. Exit (stops the client) - exit");
        System.out.println("9. Stop (stops the client & server) - stop");

        System.out.print("Enter command: ");
    }

    public void listen(){

        BufferedReader standardInput = new BufferedReader(new InputStreamReader(System.in));

        try (
                Socket socket = new Socket(serverAddress, PORT);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader (new InputStreamReader(socket.getInputStream()))
        ) {
            showCommands();
            String request = standardInput.readLine();
            String response;

            while( true ) {

                out.println(request);
                if (request.equals("exit")) {
                    socket.close();
                    System.exit(0);
                }
                if (request.equals("stop")) {
                    socket.close();
                    System.exit(0);
                }
                do {
                    response = in.readLine();
                    System.out.println(response);
                } while (!response.equals(""));


                System.out.print("Enter command: ");
                request = standardInput.readLine();

                socket.setSoTimeout(20_000);
            }

            }catch(SocketException e){
            System.err.println("User has timed out!");
        }
         catch (IOException e) {
            System.err.println("No server listening... " + e);
        }
    }

}
