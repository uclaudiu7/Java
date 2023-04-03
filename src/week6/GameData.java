package com.example.week6;
import javafx.scene.shape.Line;

import java.io.Serial;
import java.util.HashMap;
import java.util.Map;

public class GameData implements java.io.Serializable{
    @Serial
    private static final long serialVersionUID = 1L;

    private final int playerToMove;
    private final Map<Integer, SerializablePoint> dots;
    private final Map<Integer, SerializableLine> lines;
    private String player1Name;
    private String player2Name;
    private Map<Integer, SerializableLine> player1Lines;
    private Map<Integer, SerializableLine> player2Lines;

    public GameData(GameBoard gameBoard, int playerToMove){
        this.playerToMove = playerToMove;
        this.dots = gameBoard.getSerializableDots();
        this.lines = gameBoard.getSerializableLines();
        if(gameBoard.getPlayer1() == null)
            return;
        this.player1Name = gameBoard.getPlayer1().getName();
        this.player2Name = gameBoard.getPlayer2().getName();
        this.player1Lines = gameBoard.getPlayer1().getSerializableLines();
        this.player2Lines = gameBoard.getPlayer2().getSerializableLines();
    }
    public int getPlayerToMove() {
        return playerToMove;
    }
    public Map<Integer, SerializablePoint> getDots() {
        return dots;
    }
    public Map<Integer, SerializableLine> getLines() {
        return lines;
    }
    public String getPlayer1Name() {
        return player1Name;
    }
    public String getPlayer2Name() {
        return player2Name;
    }
    public Map<Integer, Line> getPlayer1Lines() {
        Map<Integer, Line> player1Lines = new HashMap<>();
        for (SerializableLine line : this.player1Lines.values()) {
            player1Lines.put(player1Lines.size(), new Line(line.getStart().getX(), line.getStart().getY(), line.getEnd().getX(), line.getEnd().getY()));
        }
        return player1Lines;
    }
    public Map<Integer, Line> getPlayer2Lines() {
        Map<Integer, Line> returnLine = new HashMap<>();
        for (SerializableLine line : this.player2Lines.values()) {
            returnLine.put(returnLine.size(), new Line(line.getStart().getX(), line.getStart().getY(), line.getEnd().getX(), line.getEnd().getY()));
        }
        return returnLine;
    }

}
