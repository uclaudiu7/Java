package com.example.week6;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.*;

public class Player {
    private final String name;
    private final Map<Integer, Line> lines;
    private final Color color;

    public Player(String name, Color color) {
        this.name = name;
        this.color = color;
        lines = new HashMap<>();
    }

    public Player(String name, Color color, Map<Integer, Line> lines) {
        this.name = name;
        this.color = color;
        this.lines = lines;
    }

    public Boolean isWinner() {
        List<Point2D> triangleDots = new ArrayList<>();
        for(int i = 0; i < lines.size()-2; i++) {
            Line line1 = lines.get(i);
            triangleDots.add(new Point2D(line1.getStartX(), line1.getStartY()));
            triangleDots.add(new Point2D(line1.getEndX(), line1.getEndY()));
            for(int j = i + 1; j < lines.size()-1; j++) {
                Line line2 = lines.get(j);
                triangleDots.add(new Point2D(line2.getStartX(), line2.getStartY()));
                triangleDots.add(new Point2D(line2.getEndX(), line2.getEndY()));
                for(int k = j + 1; k < lines.size(); k++) {
                    Line line3 = lines.get(k);
                    triangleDots.add(new Point2D(line3.getStartX(), line3.getStartY()));
                    triangleDots.add(new Point2D(line3.getEndX(), line3.getEndY()));
                    if(getUniquePoints(triangleDots) == 3) {
                        return true;
                    } else {
                        triangleDots.remove(new Point2D(line3.getStartX(), line3.getStartY()));
                        triangleDots.remove(new Point2D(line3.getEndX(), line3.getEndY()));
                    }
                }
                triangleDots.remove(new Point2D(line2.getStartX(), line2.getStartY()));
                triangleDots.remove(new Point2D(line2.getEndX(), line2.getEndY()));
            }
            triangleDots.remove(new Point2D(line1.getStartX(), line1.getStartY()));
            triangleDots.remove(new Point2D(line1.getEndX(), line1.getEndY()));
        }
        return false;
    }

    public int getUniquePoints(List<Point2D> points) {
        Set<Point2D> uniquePoints = new HashSet<>(points);
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

    public Map<Integer, SerializableLine> getSerializableLines() {
        Map<Integer, SerializableLine> serializableLines = new HashMap<>();
        for (Map.Entry<Integer, Line> entry : lines.entrySet()) {
            serializableLines.put(entry.getKey(), new SerializableLine(new SerializablePoint(entry.getValue().getStartX(), entry.getValue().getStartY()), new SerializablePoint(entry.getValue().getEndX(), entry.getValue().getEndY())));
        }
        return serializableLines;
    }

}