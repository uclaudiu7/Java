package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int size = 4;
        int numRobots = 4;
        Map map = new Map(size);

        List<Robot> robots = new ArrayList<>();
        for (int i = 1; i <= numRobots; i++) {
            Robot robot = new Robot("Robot" + i, map);
            robots.add(robot);
            Thread thread = new Thread(robot);
            thread.start();
        }
        
        Scanner scanner = new Scanner(System.in);
        InputRunnable inputRunnable = new InputRunnable(scanner, robots);
        Thread inputThread = new Thread(inputRunnable);
        inputThread.start();



    }
}


