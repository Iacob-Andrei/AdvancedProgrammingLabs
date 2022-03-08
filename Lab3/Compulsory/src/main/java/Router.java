public class Router extends Node implements Identifiable{

    private String IPaddress;

    public Router(String IPaddress, String name) {
        this.setIPAddress(IPaddress);
        this.setName(name);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name + "(Router)";
    }

    @Override
    public String getIPAddress() {
        return IPaddress;
    }

    @Override
    public void setIPAddress(String address) {
        this.IPaddress = address;
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.getName());
    }

}
