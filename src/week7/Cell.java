package org.example;

public class Cell {
    int x;
    int y;
    public Cell(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "[" + x +
                ", " + y +
                ']';
    }
}
