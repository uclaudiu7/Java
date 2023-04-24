package org.example;

public class Robot implements Runnable {
    int x;
    int y;
    private final String name;
    private final Map map;
    private boolean finished;
    private boolean running;
    private boolean paused;
    private int numTokens;

    public Robot(String name, Map map) {
        this.name = name;
        this.map = map;
        x = (int) (Math.random() * map.getSize());
        y = (int) (Math.random() * map.getSize());
        while(map.isVisited(x, y)){
            x = (int) (Math.random() * map.getSize());
            y = (int) (Math.random() * map.getSize());
        }
        running = true;
        paused = true;
        finished = false;
    }

    @Override
    public void run() {
        while(running){
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if(!paused){
                explore(x, y);
            }
            if(finished){
                System.out.println(name + ":  I finished exploring the map and placed " + numTokens + " tokens.");
                map.finishedRobot();
                running = false;
            }
        }
    }

    public synchronized void start(){
        paused = false;
        running = true;
        System.out.println(name + " has been started.");
        notify();
    }

    public synchronized void pause(long time) throws InterruptedException{
        System.out.println(name + " has been paused.");
        paused = true;
        if(time == 0){
            wait(200);
        } else {
            wait(time);
            paused = false;
        }
    }

    private void explore(int x, int y) {
        if(!paused){
            finished = true;
            if (map.visit(x, y)) {
                System.out.println(name + " -> [" + x + ", " + y + "] and extracted tokens: " + map.extractTokens());
                increaseTokens(map.getSize());
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (x < map.getSize() - 1) {
                    explore(x + 1, y);
                }
                if (x > 0) {
                    explore(x - 1, y);
                }
                if (y < map.getSize() - 1) {
                    explore(x, y + 1);
                }
                if (y > 0) {
                    explore(x, y - 1);
                }
            }
        }
    }

    public void increaseTokens(int numTokens){
        this.numTokens += numTokens;
    }

    public String getName() {
        return name;
    }

}
