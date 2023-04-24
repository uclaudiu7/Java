package org.example;

public class Robot implements Runnable {
    int x;
    int y;
    private String name;
    private Map map;
    private boolean running;
    private boolean paused;
    private int numTokens;

    public Robot(String name, Map map) {
        this.name = name;
        this.map = map;
        x = (int) (Math.random() * map.getSize());
        y = (int) (Math.random() * map.getSize());
        running = true;
        paused = false;
    }

    @Override
    public void run() {
        while(!Thread.interrupted() && running){
            if(!paused){
                explore(x, y);
            }
            if(map.isFinished()){
                System.out.println(name + " has finished exploring the map and extracted " + numTokens + " tokens.");
                running = false;
            }
        }
    }

    public synchronized void start(){
        paused = false;
        notify();
    }

    public synchronized void pause(long time) throws InterruptedException{
        System.out.println(name + " is pausing....");
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
            if (map.visit(x, y)) {
                System.out.println(name + " visited cell [" + x + ", " + y + "] and extracted tokens: " + map.extractTokens());
                increaseTokens(map.getSize());
                try {
                    Thread.sleep(1000);
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
        else{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(name + " is paused");
        }
    }

    public void increaseTokens(int numTokens){
        this.numTokens += numTokens;
    }

    public String getName() {
        return name;
    }

}
