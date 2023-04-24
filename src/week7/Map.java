package org.example;

import java.util.*;

public class Map {
    private final Cell[][] cells;
    private final boolean[][] visited;
    private final List<Integer> tokens;
    private final int numRobots;
    private int finishedRobots;
    public Map(int size, int numRobots) {
        cells = new Cell[size][size];
        visited = new boolean[size][size];
        tokens = new ArrayList<>();
        finishedRobots = 0;
        this.numRobots = numRobots;
        for(int i = 0; i < size*size*size; i++) {
            tokens.add(i+1);
        }
        Collections.shuffle(tokens);
    }
    public synchronized boolean visit(int x, int y) {
        if(!visited[x][y]) {
            visited[x][y] = true;
            return true;
        }
        return false;
    }
    public synchronized List<Integer> extractTokens() {
        List<Integer> extractedTokens = new ArrayList<>();
        for (int i = 0; i < cells.length; i++) {
            if (tokens.isEmpty()) {
                break;
            }
            extractedTokens.add(tokens.get(0));
            tokens.remove(0);
        }
        return extractedTokens;
    }
    public synchronized void finishedRobot() {
        finishedRobots++;
    }
    public synchronized boolean isFinished() {
        return finishedRobots == numRobots;
    }

    public synchronized boolean isVisited(int x, int y) {
        return visited[x][y];
    }

    public int getSize() {
        return cells.length;
    }

}

