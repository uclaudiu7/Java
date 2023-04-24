package org.example;

import java.util.*;

public class Map {
    private final int size;
    private final Cell[][] cells;
    private final boolean[][] visited;
    private final String[][] visitedByRobot;
    private final List<Integer> tokens;
    private final int numRobots;
    private int finishedRobots;
    public Map(int size, int numRobots) {
        this.size = size;
        cells = new Cell[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++){
                cells[i][j] = new Cell(i, j);
            }
        }
        visited = new boolean[size][size];
        visitedByRobot = new String[size][size];
        tokens = new ArrayList<>();
        finishedRobots = 0;
        this.numRobots = numRobots;
        for(int i = 0; i < size*size*size; i++) {
            tokens.add(i+1);
        }
        Collections.shuffle(tokens);
    }
    public synchronized void visit(int x, int y) {
        visited[x][y] = true;
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

    public synchronized String getCellRobot(int x, int y) {
        return visitedByRobot[x][y];
    }
    public synchronized void setCellRobot(int x, int y, String robotName) {
        visitedByRobot[x][y] = robotName;
    }

    public synchronized boolean isVisited(int x, int y) {
        return visited[x][y];
    }
    public List<Cell> getNeighbours(int x, int y) {
        List<Cell> neighbours = new ArrayList<>();
        if(x > 0) {
            neighbours.add(cells[x-1][y]);
        }
        if(x < cells.length-1) {
            neighbours.add(cells[x+1][y]);
        }
        if(y > 0) {
            neighbours.add(cells[x][y-1]);
        }
        if(y < cells.length-1) {
            neighbours.add(cells[x][y+1]);
        }
        return neighbours;
    }
    public int getSize() {
        return cells.length;
    }
    public void printMap() {
        // Top border
        for (int i = 0; i < size; i++) {
            System.out.print("+--------");
        }
        System.out.println("+");

        // Map
        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++) {
                System.out.print("| ");
                if (this.isVisited(x, y)) {
                    System.out.print(getCellRobot(x, y));
                } else {
                    System.out.print(" ");
                }
                System.out.print(" ");
            }
            System.out.println("|");

            // Bottom border
            for (int i = 0; i < size; i++) {
                System.out.print("+--------");
            }
            System.out.println("+");
        }
    }

}