public class Router extends Node implements Identifiable{

    private String IPaddress;

    public Router(String IPaddress, String name) {
        this.setIPAddress(IPaddress);
        this.setName(name);
    }

    public void setCost(Node node, int value){
        cost.put(node, value);
    }

    public String getCosts(){

        StringBuilder sb = new StringBuilder();

        for( Node node : cost.keySet()){

            String name = node.getName();
            int value = cost.get(node);
            sb.append( this.getName() + " -- " + name + "  " + value + "\n" );
        }

        return sb.toString();
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
        return name + "(Router, "+ getIPAddress() +")";
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
