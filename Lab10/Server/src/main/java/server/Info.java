package server;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Info {
    private static List<String> users = new ArrayList<>();
    private static Map<String, Set<String>> friends = new HashMap<>();
    private static Map<String, List<String>> messages = new HashMap<>();

    static {
        load_users();
       load_friends();
       load_messages();
    }

    private static void load_users() {
        try {
            File users_file = new File("src/main/resources/users.txt");
            Scanner reader = new Scanner(users_file);

            while (reader.hasNextLine()) {
                String user = reader.nextLine();
                if (!user.equals("")) {
                    users.add(user);
                    friends.put(user, new LinkedHashSet<>());
                    messages.put(user, new LinkedList<>());
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void load_friends() {
        try {
            File friends_file = new File("src/main/resources/friends.txt");
            Scanner reader = new Scanner(friends_file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] friendsAssoc = line.split(" ");

                friends.get(friendsAssoc[0]).add(friendsAssoc[1]);
                friends.get(friendsAssoc[1]).add(friendsAssoc[0]);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static void load_messages() {
        try {
            File messages_file = new File("src/main/resources/messages.txt");
            Scanner reader = new Scanner(messages_file);

            while (reader.hasNextLine()) {
                String line = reader.nextLine();

                if (!line.equals("")) {
                    List<String> message = new LinkedList<>(Arrays.asList(line.split(" ", 2)));

                    String toList = message.get(0);

                    String text = message.get(1);

                    String[] to = toList.split(",");
                    for (String receiver : to) {
                        messages.get(receiver).add(text);
                    }
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static String addUser(String user) {
        if (users.contains(user))
            return "user already exists";

        Path path = Paths.get("src/main/resources/users.txt");

        try {
            Files.write(path, (user + "\n").getBytes(), StandardOpenOption.APPEND);  //Append mode
            users.add(user);
            friends.put(user,new LinkedHashSet<>());
            messages.put(user,new LinkedList<>());

            return "user successfully added";
        } catch (IOException e) {
            return "error on adding user.";
        }
    }

    public static String addFriend(String user1, String user2) {
        if (!(users.contains(user1) && users.contains(user2)))
            return user1 + " or " + user2 + " does not exists.";

        Path path = Paths.get("src/main/resources/friends.txt");
        try {
            Files.write(path, (user1 + " " + user2 + "\n").getBytes(), StandardOpenOption.APPEND);  //Append mode
            Files.write(path, (user2 + " " + user1 + "\n").getBytes(), StandardOpenOption.APPEND);  //Append mode

            friends.get(user1).add(user2);
            friends.get(user2).add(user1);

            return "friendship relation added";
        } catch (IOException e) {
            return "error on adding the friendship relation.";
        }
    }

    public static String sendMessage(String to, String message) {
        if (!users.contains(to))
            return "user does not exists.";

        Path path = Paths.get("src/main/resources/messages.txt");
        message = message.trim();
        try{
            Files.write(path, (to + " " + message + "\n").getBytes(), StandardOpenOption.APPEND);
            messages.get(to).add(message);
            return "message sent to " + to;
        } catch (IOException e) {
            return "error on adding the message";
        }

    }
    public static List<String> getUsers() {
        return users;
    }

    public static void setUsers(List<String> users) {
        Info.users = users;
    }

    public static Map<String, Set<String>> getFriends() {
        return friends;
    }

    public static void setFriends(Map<String, Set<String>> friends) {
        Info.friends = friends;
    }

    public static String getMessages(String userName) {
        StringBuilder result = new StringBuilder(new StringBuilder());

        if (!users.contains(userName))
            return "invalid username";

        List<String> userMessages = messages.get(userName);

        for (String message : userMessages)
            result.append(message).append("\n");

        if (result.length() > 0)
            result = new StringBuilder(result.substring(0, result.length() - 1));

        return result.toString();
    }

    public static void setMessages(Map<String, List<String>> messages) {
        Info.messages = messages;
    }
}
