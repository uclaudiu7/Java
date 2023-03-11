package week3;

import javax.swing.*;
import java.time.LocalDate;

public class Homework {
    public static void main(String[] args){
        Network network = new Network();

        Person andrei = new Person("Andrei", LocalDate.of(2002,9,3));
        Person robert = new Person("Robert", LocalDate.of(2003, 1, 1));
        Programmer claudiu = new Programmer("Claudiu", LocalDate.of(2002, 7, 5), 1, "Java");
        Programmer radu = new Programmer("Radu", LocalDate.of(2002, 6, 10), 5, "Alk");
        Designer marian = new Designer("Marian", LocalDate.of(2002, 3, 15), "UI/UX");
        Designer stefan = new Designer("Stefan", LocalDate.of(2001, 10, 25), "Front-end");

        Company bitdefender = new Company("Bitdefender");
        Company continental = new Company("Continental");
        Company amazon = new Company("Amazon");

        claudiu.addRelationship(andrei, "Friend");
        claudiu.addRelationship(robert, "Friend");
        radu.addRelationship(robert, "Friend");
        radu.addRelationship(stefan, "Cousin");
        claudiu.addRelationship(marian, "Brother");
        radu.addRelationship(claudiu, "Friend");

        radu.addRelationship(amazon, "Developer");
        robert.addRelationship(bitdefender, "Intern");
        claudiu.addRelationship(bitdefender, "Intern");
        andrei.addRelationship(amazon, "Developer");
        marian.addRelationship(continental, "Designer");

        network.addNode(andrei);
        network.addNode(robert);
        network.addNode(claudiu);
        network.addNode(radu);
        network.addNode(marian);
        network.addNode(stefan);
        network.addNode(bitdefender);
        network.addNode(continental);
        network.addNode(amazon);

        System.out.println("Nodes in the network and their importance: ");
        network.sortByImportance();
        for(Node node : network.getNodes()) {
            System.out.println(node.getName() + ": " + node.getImportance());
        }
    }
}
