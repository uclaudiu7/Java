package com.example.week6;

import java.io.Serializable;

public class SerializablePoint implements Serializable {
    private static final long serialVersionUID = 1L;
    private double x;
    private double y;

    public SerializablePoint(double x, double y){
        this.x = x;
        this.y = y;
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
