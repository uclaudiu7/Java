package week3;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Compulsory {
    public static void main(String[] args) {
        List<Node> nodes = new ArrayList<>();

        nodes.add(new Person("John", LocalDate.of(1990, 6, 12)));
        nodes.add(new Company("Microsoft"));
        nodes.add(new Person("Mary", LocalDate.of(2002, 5, 7)));
        nodes.add(new Company("Google"));

        for (Node node : nodes) {
            Node.Print(node);
        }
    }
}
