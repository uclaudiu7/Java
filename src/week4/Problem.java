package org.example;

import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
/**
 * Class for the problem
 */
public class Problem {
    /**
     * List of students
     */
    List<Student> students;
    /**
     * List of projects
     */
    List<Project> projects;
    /**
     * Constructor for the problem
     * @param students
     * @param projects
     */
    public Problem(List<Student> students, List<Project> projects) {
        this.students = students;
        this.projects = projects;
    }
    /**
     * Constructor for the problem
     */
    public Problem(){}
    /**
     * Getter for students
     * @return students
     */
    public List<Student> getStudents() {
        return students;
    }
    /**
     * Setter for students
     * @param students
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }
    /**
     * Getter for projects
     * @return projects
     */
    public List<Project> getProjects() {
        return projects;
    }
    /**
     * Setter for projects
     * @param projects
     */
    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
    /**
     * Method for solving the problem
     * @return matching set of students and projects
     */
    public Set<Matching> solve(){
        Set<Matching> result = new HashSet<>();
        List<Project> projects = this.getProjects();
        List<Student> students = this.getStudents();

        projects.sort((p1, p2) -> Integer.compare(p2.getAdmissibleStudents().size(), p1.getAdmissibleStudents().size()));
        students.sort((s1, s2) -> Integer.compare(s1.getAdmissibleProjects().size(), s2.getAdmissibleProjects().size()));

        while (projects.size() > 0 && students.size() > 0){
            Student priorityStudent = students.get(0);
            for(int i = 0; i < projects.size(); i++)
                if(priorityStudent.getAdmissibleProjects().contains(projects.get(i))){
                    result.add(new Matching(priorityStudent, projects.get(i)));
                    students.remove(priorityStudent);
                    projects.remove(projects.get(i));
                    break;
                }
            students.remove(priorityStudent);
        }

        return result;
    }
    /**
     * Method for generating random names
     */
    public List<Student> generateRandomNames(){
        List<Student> studentList = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 10; i++){
            String name = faker.name().firstName();
            studentList.add(new Student(name));
        }
        return studentList;
    }
    /**
     * Method for generating random projects
     */
    public List<Project> generateRandomProjects(){
        List<Project> projectList = new ArrayList<>();
        Faker faker = new Faker();
        for(int i = 0; i < 10; i++){
            String name = faker.app().name();
            projectList.add(new Project(name));
        }
        return projectList;
    }
    /**
     * Method for random assignment of students to projects
     */
    public void randomAssingment(){
        for(Student student : students){
            for(Project project : projects){
                if(Math.random() < 0.2){
                    student.addPreference(project);
                    project.addStudent(student);
                }
            }
        }
    }
    /**
     * Method for getting the average number of preferences
     */
    public double getAveragePreferences() {
        double average = students.stream()
                .mapToInt(student -> student.getAdmissibleProjects().size())
                .average()
                .orElse(0.0);
        return average;
    }
    /**
     * Method for printing students with fewer preferences than the average
     */
    public void printStudentsFewer() {
        double average = this.getAveragePreferences();

        List<Student> studentsFewer = students.stream()
                .filter(s -> s.getAdmissibleProjects().size() < average)
                .collect(Collectors.toList());

        System.out.println("Average number of preferences: " + average);
        System.out.println("Students with fewer preferences than the average: " + studentsFewer);
    }

}
