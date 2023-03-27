package com.example.week6;

import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CanvasPanel extends BorderPane {

    private final Canvas canvas;
    private GraphicsContext gc;
    private Map<Integer, Point2D> dots;

    public CanvasPanel(Canvas canvas) {
        this.canvas = canvas;
        dots = new HashMap<>();
        gc = canvas.getGraphicsContext2D();
        setCenter(canvas);
    }

    public void drawDots(int numDots, double lineProbability) {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());

        double radius = Math.min(canvas.getWidth(), canvas.getHeight()) / 2 * 0.9;
        double centerX = canvas.getWidth() / 2;
        double centerY = canvas.getHeight() / 2;
        double angle = 2 * Math.PI / numDots;

        for (int i = 0; i < numDots; i++) {
            double x = centerX + radius * Math.cos(i * angle);
            double y = centerY + radius * Math.sin(i * angle);
            gc.setFill(Color.BLACK);
            gc.fillOval(x - 5, y - 5, 10, 10);
            dots.put(i, new Point2D(x, y));
        }
        drawLines(lineProbability);
    }

    public void drawLines(double lineProbability) {
        Random random = new Random();
        gc.setLineWidth(2);
        for(int i = 0; i < dots.size()-1; i++) {
            Point2D dot1 = dots.get(i);
            for(int j = i + 1; j < dots.size(); j++) {
                if(random.nextDouble() < lineProbability) {
                    Point2D dot2 = dots.get(j);
                    gc.setStroke(Color.BLACK);
                    gc.strokeLine(dot1.getX(), dot1.getY(), dot2.getX(), dot2.getY());
                }
            }
        }
    }
}