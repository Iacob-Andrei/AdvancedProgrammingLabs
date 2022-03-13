import java.util.Map;

public class Switch extends Node{

    public Switch( String name) {
        this.name = name;
    }

    /**
     * add node and value to hashmap
     * @param node to be added
     * @param value cost
     */
    public void setCost(Node node, int value){
        cost.put(node, value);
    }

    /**
     * @return the costs to go from current node to another node
     */
    public String getCosts(){

        StringBuilder sb = new StringBuilder();

        for( Node node : cost.keySet()){

            String name = node.getName();
            int value = cost.get(node);
            sb.append(this.getName()).append(" -- ").append(name).append("  ").append(value).append("\n");
        }

        return sb.toString();
    }

    public Map<Node, Integer> getCost(){
        return cost;
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
        return name + "(Switch)";
    }

    @Override
    public int compareTo(Node other) {
        return this.name.compareTo(other.getName());
    }

}
