package org.example;

import java.util.ArrayList;
import java.util.List;
/**
 * Class for the student
 */
public class Student implements Comparable{
    /**
     * Name of the student
     */
    private String name;
    /**
     * List of admissible projects
     */
    List<Project> admissibleProjects;
    /**
     * Constructor for the student
     * @param name
     */
    public Student(String name) {
        this.name = name;
        this.admissibleProjects = new ArrayList<>();
    }
    /**
     * Constructor for the student
     * @param name
     * @param admissibleProjects
     */
    public Student(String name, List<Project> admissibleProjects) {
        this.name = name;
        this.admissibleProjects = admissibleProjects;
        admissibleProjects.forEach(p -> p.addStudent(this));
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
     * Getter for admissible projects
     * @return admissible projects
     */
    public List<Project> getAdmissibleProjects() {
        return admissibleProjects;
    }
    /**
     * Method for adding a project to the list of admissible projects
     */
    public void addPreference(Project project) {
        this.admissibleProjects.add(project);
    }
    /**
     * Setter for admissible projects
     */
    public void setAdmissibleProjects(List<Project> admissibleProjects) {
        this.admissibleProjects = admissibleProjects;
    }
    /**
     * To string method
     */
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                //", admissibleProjects=" + admissibleProjects +
                '}';
    }
    /**
     * Overriding compareTo method
     * @param o
     * @return
     */
    public int compareTo(Object o) {
        Student s = (Student) o;
        return this.name.compareTo(s.name);
    }
}
