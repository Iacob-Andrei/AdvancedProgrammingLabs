public class Computer extends Node implements Identifiable, Storage {

    private String IPaddress;
    private int storageCapacity;

    Computer(String address, int storageCapacity, String name){
        this.setIPAddress(address);;
        this.setStorageCapacity(storageCapacity);
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
        return name + "(Computer," + getStorageInMegabytes(getStorageCapacity()) + " MB, " + getIPAddress() +")";
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
    public int compareTo(Node other) {
        return this.name.compareTo(other.getName());
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
    public int getStorageCapacity() {
        return storageCapacity;
    }

    @Override
    public void setStorageCapacity(int storageCapacity) {
        this.storageCapacity = storageCapacity;
    }
}