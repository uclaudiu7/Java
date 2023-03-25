package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.github.javafaker.Faker;
/**
 *  Main class for the homework
 */
public class Homework {
    public static void main(String[] args) {
        List<Project> projectList  = new ArrayList<>();
        List<Student> studentList = new ArrayList<>();

        Problem problem = new Problem();
        studentList = problem.generateRandomNames();
        projectList = problem.generateRandomProjects();
        problem.setStudents(studentList);
        problem.setProjects(projectList);
        problem.randomAssingment();

        //problem.getProjects().stream().sorted().forEach(System.out::println);
        //problem.getStudents().stream().sorted().forEach(System.out::println);

        problem.printStudentsFewer();

        Set<Matching> matching = problem.solve();
        System.out.println(matching);

    }

}
