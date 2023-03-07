package week3;

public class Company implements Node{
    private String name;

    public Company(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return "Company";
    }
}
