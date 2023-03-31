package com.example.week6;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameBoard implements java.io.Serializable{
    private Map<Integer, Point2D> dots;
    private Map<Integer, Line> backupLines;
    private Map<Integer, Line> lines;
    private Canvas canvas;
    private Player player1;
    private Player player2;

    public GameBoard(Canvas canvas) {
        this.canvas = canvas;
        dots = new HashMap<>();
        lines = new HashMap<>();
    }

    public void newGame(int numDots, double lineProbability, String player1Name, String player2Name) {
        if(player1Name == null || player1Name.isEmpty()) {
            player1 = new Player("Player 1", Color.BLUE);
        }
        else{
            player1 = new Player(player1Name, Color.BLUE);
        }
        if(player2Name == null || player2Name.isEmpty()) {
            player2 = new Player("Player 2", Color.RED);
        }
        else{
            player2 = new Player(player2Name, Color.RED);
        }
        dots.clear();
        lines.clear();
        double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2 * 0.9;
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;
        double angle = 2 * Math.PI / numDots;

        for (int i = 0; i < numDots; i++) {
            double x = centerX + radius * Math.cos(i * angle);
            double y = centerY + radius * Math.sin(i * angle);
            dots.put(i, new Point2D(x, y));
        }

        Random random = new Random();
        for(int i = 0; i < dots.size()-1; i++) {
            Point2D dot1 = dots.get(i);
            for(int j = i + 1; j < dots.size(); j++) {
                if(random.nextDouble() < lineProbability) {
                    Point2D dot2 = dots.get(j);
                    Line line = new Line(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY());
                    lines.put(lines.size(), line);
                }
            }
        }
        backupLines = new HashMap<>(lines);
    }

    public void resetGame(){
        lines = new HashMap<>(backupLines);
        player1.getLines().clear();
        player2.getLines().clear();
    }

    public void removeLine(Line line) {
        lines.values().remove(line);
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public Map<Integer, Point2D> getDots() {
        return dots;
    }

    public Map<Integer, Line> getLines() {
        return lines;
    }

}


