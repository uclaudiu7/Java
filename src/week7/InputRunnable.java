package org.example;

import java.util.List;
import java.util.Scanner;

class InputRunnable implements Runnable {
    private final Scanner scanner;
    private final List<Robot> robots;

    public InputRunnable(Scanner scanner, List<Robot> robots) {
        this.scanner = scanner;
        this.robots = robots;
    }

    public void run() {
        while(true){
            String command = scanner.nextLine();
            if(command.equals("start all")){
                for(Robot robot : robots){
                    robot.start();
                    System.out.println(robot.getName() + " started");
                }
            } else if(command.startsWith("start")){
                int robotIndex = Integer.parseInt(command.split(" ")[1]);
                robots.get(robotIndex-1).start();
            } else if (command.equals("pause all")) {
                for(Robot robot : robots){
                    try {
                        robot.pause(0);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    System.out.println("---paused all");
                }
            } else if(command.startsWith("pause ")){
                String[] words = command.split("\\s+");
                if(words.length == 2){
                    if(command.split(" ")[1].equals("all")){
                        for (Robot robot : robots) {
                            try {
                                robot.pause(0);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else{
                        int robotIndex = Integer.parseInt(command.split(" ")[1]);
                        try {
                            robots.get(robotIndex-1).pause(0);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                } else if(words.length == 3){
                    if(command.split(" ")[1].equals("all")){
                        int time = Integer.parseInt(command.split(" ")[2]);
                        for(Robot robot : robots){
                            try {
                                robot.pause(time);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                    } else{
                        int robotIndex = Integer.parseInt(command.split(" ")[1]);
                        int time = Integer.parseInt(command.split(" ")[2]);
                        try {
                            robots.get(robotIndex-1).pause(time);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            } else if (command.equals("exit")) {
                break;
            }
        }
    }
}
