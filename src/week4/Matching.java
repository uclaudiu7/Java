package org.example;

import com.github.javafaker.Faker;
/**
 * Class for matching students with projects
 */
public class Matching {
    /**
     * Student
     */
    private Student student;
    /**
     * Project
     */
    private Project project;
    /**
     * Constructor for matching
     * @param student
     * @param project
     */
    public Matching(Student student, Project project) {
        this.student = student;
        this.project = project;

    }
    /**
     * Getter for student
     * @return student
     */
    public Student getStudent() {
        return student;
    }
    /**
     * Setter for student
     * @param student
     */
    public void setStudent(Student student) {
        this.student = student;
    }
    /**
     * Getter for project
     * @return project
     */
    public Project getProject() {
        return project;
    }
    /**
     * Setter for project
     * @param project
     */
    public void setProject(Project project) {
        this.project = project;
    }
    /**
     * Overriding toString method
     * @return String
     */
    @Override
    public String toString() {
        return "Matching{" +
                "student=" + student.getName() +
                ", project=" + project.getName() +
                '}';
    }
}
