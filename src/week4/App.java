package org.example;

import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;
import java.util.stream.Collectors;
import java.util.stream.Stream;
public class App
{
    public static void main( String[] args ) {
        Stream<String> students = Stream.of("S0", "S1", "S2");
        Stream<String> projects = Stream.of("P0", "P1", "P2");

        LinkedList<Student> studentList = new LinkedList<>();
        TreeSet<Project> projectSet = new TreeSet<>();

        studentList.addAll(students.map(Student::new).collect(Collectors.toList()));
        Collections.sort(studentList);
        projectSet.addAll(projects.map(Project::new).collect(Collectors.toList()));

        System.out.println("Student list:" + studentList);
        System.out.println("Project set:" + projectSet);

    }
}
