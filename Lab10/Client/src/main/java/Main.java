public class Main {

    public static void main(String[] args) {
        SimpleClient client = new SimpleClient("127.0.0.1", 8100);
        client.listen();
    }
}
