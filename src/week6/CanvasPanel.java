package com.example.week6;

import javafx.event.EventHandler;
import javafx.geometry.Point2D;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.util.Map;

public class CanvasPanel extends BorderPane {

    private final Canvas canvas;
    private GraphicsContext gc;
    private Map<Integer, Point2D> dots;
    private Map<Integer, Line> lines;
    private GameBoard gameBoard;
    private Text turnText;
    private int playerToMove = 1;

    private EventHandler<MouseEvent> clickHandler = new EventHandler<MouseEvent>() {
        @Override
        public void handle(MouseEvent event) {
            Point2D point = new Point2D(event.getX(), event.getY());
            Line closestLine = null;
            for (Line line : gameBoard.getLines().values()) {
                if (distanceToLine(point, line) < 10) {
                    if(closestLine == null) {
                        closestLine = line;
                    } else if (distanceToLine(point, line) < distanceToLine(point, closestLine)) {
                        closestLine = line;
                    }
                }
            }
            if (closestLine != null) {
                if(playerToMove == 1) {
                    setTurnText("Player to chose: " + gameBoard.getPlayer2().getName());
                    playerMove(gameBoard.getPlayer1(), closestLine);
                    playerToMove = 2;
                } else {
                    setTurnText("Player to chose: " + gameBoard.getPlayer1().getName());
                    playerMove(gameBoard.getPlayer2(), closestLine);
                    playerToMove = 1;
                }
                gc.strokeLine(closestLine.getStartX(), closestLine.getStartY(), closestLine.getEndX(), closestLine.getEndY());
            }
        }
    };;

    public CanvasPanel(Canvas canvas, GameBoard gameBoard) {
        this.canvas = canvas;
        this.gameBoard = gameBoard;
        gc = canvas.getGraphicsContext2D();
        turnText = new Text();
        turnText.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        turnText.setFill(Color.GREY);
        turnText.setText("Player to chose: ");
        turnText.setX(10);
        turnText.setY(30);
        this.getChildren().add(turnText);
        setCenter(canvas);
        canvas.setOnMouseClicked(clickHandler);
    }

    public void startListening() {
        canvas.setOnMouseClicked(clickHandler);
    }

    public void stopListening() {
        canvas.setOnMouseClicked(null);
    }

    public void render(){
        turnText.setFont(Font.font("Arial", FontWeight.NORMAL, 15));
        turnText.setFill(Color.GREY);
        turnText.setX(10);
        turnText.setY(30);
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setLineWidth(2);
        dots = gameBoard.getDots();
        lines = gameBoard.getLines();
        for (int i = 0; i < dots.size(); i++) {
            Point2D dot = dots.get(i);
            gc.setFill(Color.BLACK);
            gc.fillOval(dot.getX() - 5, dot.getY() - 5, 10, 10);
        }
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            gc.setStroke(Color.BLACK);
            gc.strokeLine(line.getStartX(), line.getStartY(), line.getEndX(), line.getEndY());
        }
    }

    private double distanceToLine(Point2D point, Line line) {
        double x1 = line.getStartX();
        double y1 = line.getStartY();
        double x2 = line.getEndX();
        double y2 = line.getEndY();
        double x0 = point.getX();
        double y0 = point.getY();
        return Math.abs((y2 - y1) * x0 - (x2 - x1) * y0 + x2 * y1 - y2 * x1) / Math.sqrt(Math.pow(y2 - y1, 2) + Math.pow(x2 - x1, 2));
    }

    public void setTurnText(String text) {
        turnText.setText(text);
    }

    public void playerMove(Player player, Line closestLine){
        player.addLine(closestLine);
        gameBoard.removeLine(closestLine);
        gc.setStroke(player.getColor());
        checkWinner(player);
    }

    public void checkWinner(Player player) {
        if (player.isWinner()) {
            String victoryText = "🎉 " + player.getName() + " wins! 🎉";
            turnText.setFill(Color.GREEN);
            turnText.setX(10);
            turnText.setY(30);
            setTurnText(victoryText);
            stopListening();
        }
    }

    public Canvas getCanvas() {
        return canvas;
    }

}