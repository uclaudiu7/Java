package week3;

import java.util.ArrayList;
import java.util.List;

public class Compulsory {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Person("John"));
        nodes.add(new Company("Microsoft"));
        nodes.add(new Person("Mary"));
        nodes.add(new Company("Google"));

        for (Node node : nodes) {
            Node.Print(node);
        }
    }
}
