package week3;

import java.util.*;

public class Company implements Node, Comparable<Company>{
    private String name;
    private Map<String, String> employees;

    public Company(String name) {
        this.name = name;
        employees = new HashMap<>();
    }
    public void addEmployee(Person person, String position){
        employees.put(person.getName(), position);
    }
    public String getName() {
        return name;
    }
    public String getType() {
        return "Company";
    }
    public int getImportance(){
        return employees.size();
    }
    @Override
    public int compareTo(Company o) {
        return this.name.compareTo(o.getName());
    }
}
