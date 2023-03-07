package week3;

public class Person implements Node{
    private String name;
    public Person(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return "Person";
    }
}
