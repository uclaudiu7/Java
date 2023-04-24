package org.example;

public class Timekeeper extends Thread{
    private final long timeLimit;
    private final long startTime;
    private final Map map;

    public Timekeeper(long timeLimit, Map map){
        this.timeLimit = timeLimit*1000;
        this.map = map;
        this.startTime = System.currentTimeMillis();
        setDaemon(true);
    }

    @Override
    public void run() {
        while(true){
            long elapsedTime = System.currentTimeMillis() - startTime;
            if(elapsedTime >= timeLimit){
                System.out.println("Time limit reached: " + timeLimit +" miliseconds. Exiting...");
                System.exit(0);
            } else if(map.isFinished()){
                System.out.println("Timekeeper:  Map has been fully explored in " + elapsedTime + " miliseconds.");
                System.exit(0);
            }
        }
    }
}
