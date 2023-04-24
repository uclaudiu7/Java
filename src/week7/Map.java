package org.example;

import java.util.*;

public class Map {
    private Cell[][] cells;
    private boolean[][] visited;
    private List<Integer> tokens;
    private int numVisited;

    public Map(int size) {
        cells = new Cell[size][size];
        visited = new boolean[size][size];
        tokens = new ArrayList<>();
        numVisited = 0;
        for(int i = 0; i < size*size*size; i++) {
            tokens.add(i+1);
        }
        Collections.shuffle(tokens);
    }

    public synchronized boolean visit(int x, int y) {
        if(!visited[x][y]) {
            visited[x][y] = true;
            numVisited++;
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

    public synchronized boolean isFinished() {
        return numVisited == cells.length * cells.length;
    }

    public int getSize() {
        return cells.length;
    }

}

