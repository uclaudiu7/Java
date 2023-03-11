package week3;

import java.util.ArrayList;
import java.util.List;

public class Network {
    private List<Node> nodes;

    public Network() {
        this.nodes = new ArrayList<>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public List<Node> getNodes() {
        return nodes;
    }

    public void sortByImportance(){
        nodes.sort((n1, n2) -> Integer.compare(n2.getImportance(), n1.getImportance()));
    }
}
