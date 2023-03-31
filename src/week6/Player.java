package com.example.week6;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.*;

public class Player {
    private String name;
    private Map<Integer, Point2D> dots;
    private Map<Integer, Line> lines;
    private Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        dots = new HashMap<>();
        lines = new HashMap<>();
    }

    public Boolean isWinner() {
        List<Point2D> triagleDots = new ArrayList<>();
        for(int i = 0; i < lines.size()-2; i++) {
            Line line1 = lines.get(i);
            triagleDots.add(new Point2D(line1.getStartX(), line1.getStartY()));
            triagleDots.add(new Point2D(line1.getEndX(), line1.getEndY()));
            for(int j = i + 1; j < lines.size()-1; j++) {
                Line line2 = lines.get(j);
                triagleDots.add(new Point2D(line2.getStartX(), line2.getStartY()));
                triagleDots.add(new Point2D(line2.getEndX(), line2.getEndY()));
                for(int k = j + 1; k < lines.size(); k++) {
                    Line line3 = lines.get(k);
                    triagleDots.add(new Point2D(line3.getStartX(), line3.getStartY()));
                    triagleDots.add(new Point2D(line3.getEndX(), line3.getEndY()));
                    if(getUniquePoints(triagleDots) == 3) {
                        return true;
                    } else {
                        triagleDots.remove(new Point2D(line3.getStartX(), line3.getStartY()));
                        triagleDots.remove(new Point2D(line3.getEndX(), line3.getEndY()));
                    }
                }
                triagleDots.remove(new Point2D(line2.getStartX(), line2.getStartY()));
                triagleDots.remove(new Point2D(line2.getEndX(), line2.getEndY()));
            }
            triagleDots.remove(new Point2D(line1.getStartX(), line1.getStartY()));
            triagleDots.remove(new Point2D(line1.getEndX(), line1.getEndY()));
        }
        return false;
    }

    public int getUniquePoints(List<Point2D> points) {
        Set<Point2D> uniquePoints = new HashSet<>();
        for(Point2D point : points) {
            uniquePoints.add(point);
        }
        return uniquePoints.size();
    }

    public void addLine(Line line) {
        lines.put(lines.size(), line);
    }

    public Map<Integer, Line> getLines() {
        return lines;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }
}
