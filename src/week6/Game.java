package com.example.week6;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.*;

public class Game{
    private Canvas canvas;
    private GameBoard gameBoard;
    private CanvasPanel canvasPanel;
    private ConfigPanel configPanel;
    private ControlPanel controlPanel;
    private BorderPane mainFrame;
    private Scene scene;
    private Stage primaryStage;
    private Player player1;
    private Player player2;
    public Game(Stage primaryStage){
        canvas = new Canvas(700, 500);
        gameBoard = new GameBoard(canvas);
        canvasPanel = new CanvasPanel(canvas, gameBoard);
        configPanel = new ConfigPanel(canvasPanel, gameBoard);
        controlPanel = new ControlPanel(canvasPanel, gameBoard, this);
        this.primaryStage = primaryStage;

        mainFrame = new BorderPane();
        mainFrame.setTop(configPanel);
        mainFrame.setCenter(canvasPanel);
        mainFrame.setBottom(controlPanel);
        BorderPane.setMargin(canvasPanel, new Insets(10, 10, 10, 10));

        scene = new Scene(mainFrame);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Coloring Game");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(700);
    }

    public void saveGame(){
        System.out.println("Save Game");
        try{
            FileOutputStream fileOut = new FileOutputStream("C:\\Users\\urses\\Desktop\\game.ser");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(gameBoard);
            objectOut.close();
            fileOut.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public void loadGame(){
        System.out.println("Load Game");
    }

    public void startGame(){
        primaryStage.show();
    }

}
