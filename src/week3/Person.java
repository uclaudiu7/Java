package week3;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.time.LocalDate;

public class Person implements Node, Comparable<Person>{
    private String name;
    private LocalDate birthDate;
    private Map<String, String> relationships;

    public Person(String name, LocalDate birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.relationships = new HashMap<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public Map<String, String> getRelationships() {
        return relationships;
    }

    public void addRelationship(Person person, String relationshipType){
        relationships.put(person.getName(), relationshipType);
        person.relationships.put(this.name, relationshipType);
    }

    public void addRelationship(Company company, String position){
        relationships.put(company.getName(), position);
        company.addEmployee(this, position);
    }

    public String getType() {
        return "Person";
    }

    public int getImportance(){
        return relationships.size();
    }

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }
}
