package org.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
/**
 * Class for the project
 */
public class Project implements Comparable{
    /**
     * Name of the project
     */
    private String name;
    /**
     * List of admissible students
     */
    Set<Student> admissibleStudents;
    /**
     * Constructor for the project
     * @param name
     */
    public Project(String name) {
        this.name = name;
        this.admissibleStudents = new HashSet<>();
    }
    /**
     * Getter for name
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter for admissible students
     * @return admissible students
     */
    public Set<Student> getAdmissibleStudents() {
        return admissibleStudents;
    }
    /**
     * Method for adding a student to the list of admissible students
     */
    public void addStudent(Student student) {
        this.admissibleStudents.add(student);
    }
    /**
     * To string method
     */
    @Override
    public String toString() {
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }
    /**
     * Compare to method
     */
    public int compareTo(Object o) {
        Project p = (Project) o;
        return this.name.compareTo(p.name);
    }
}
