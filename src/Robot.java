package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Robot implements Runnable {
    int xPos;
    int yPos;
    private final String name;
    private final Map map;
    private List<Cell> neighbours;
    private final Stack<Cell> path = new Stack<>();
    private boolean running;
    private boolean paused;
    private int numTokens;

    public Robot(String name, Map map) {
        this.name = name;
        this.map = map;
        this.neighbours = new ArrayList<>();
        xPos = (int) (Math.random() * map.getSize());
        yPos = (int) (Math.random() * map.getSize());
        while(map.getCellRobot(xPos, yPos) != null){
            xPos = (int) (Math.random() * map.getSize());
            yPos = (int) (Math.random() * map.getSize());
        }
        map.setCellRobot(xPos, yPos, name);
        running = true;
        paused = true;
    }

    @Override
    public void run() {
        while(running){
            try{
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(!paused){
                explore(xPos, yPos);
            }
        }
    }

    public synchronized void start(){
        paused = false;
        System.out.println(name + " is starting at position: [" + xPos + ", " + yPos + "]...");
        notify();
    }

    public synchronized void pause(long time) throws InterruptedException{
        System.out.println(name + " hase been paused.");
        paused = true;

        if(time == 0){
            wait(200);
        } else {
            wait(time*1000);
            paused = false;
        }
    }

    private void explore(int startX, int startY) {
        if(!map.isVisited(startX, startY)){
            map.visit(startX, startY);
            map.setCellRobot(startX, startY, name);
            increaseTokens(map.getSize());
            System.out.println(name + " -> [" + startX + ", " + startY + "] and extracted tokens: " + map.extractTokens());
            neighbours = map.getNeighbours(startX, startY);
            for(Cell cell: neighbours){
                if(!map.isVisited(cell.getX(), cell.getY())){
                    path.push(cell);
                }
            }
        }
        if(!path.isEmpty()){
            Cell nextCell = path.pop();
            xPos = nextCell.getX();
            yPos = nextCell.getY();
        } else if(isFinished()){
            System.out.println(name + ":  I finished exploring the map and placed " + numTokens + " tokens.");
            map.finishedRobot();
            running = false;
        }
    }

    public boolean isFinished(){
        for(Cell cell: neighbours){
            if(!map.isVisited(cell.getX(), cell.getY())){
                return false;
            }
        }
        return true;
    }

    public boolean isPaused(){
        return paused;
    }

    public void increaseTokens(int numTokens){
        this.numTokens += numTokens;
    }
}