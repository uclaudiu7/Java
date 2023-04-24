package org.example;

import java.util.ArrayList;
import java.util.List;

public class Cell {
    int x;
    int y;
    private List<Integer> tokens;
    private boolean visited;

    public Cell(int x, int y){
        this.x = x;
        this.y = y;
        this.tokens = tokens;
        this.visited = false;
    }

    public synchronized void visit(String robotName){
        while(visited){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        visited = true;
        notifyAll();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
}
