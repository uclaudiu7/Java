package com.example.week6;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.*;

public class Game{
    private final GameBoard gameBoard;
    private final CanvasPanel canvasPanel;
    private final ConfigPanel configPanel;
    private final Stage primaryStage;
    public Game(Stage primaryStage){
        this.primaryStage = primaryStage;

        Canvas canvas = new Canvas(700, 500);
        gameBoard = new GameBoard(canvas);
        canvasPanel = new CanvasPanel(canvas, gameBoard);
        configPanel = new ConfigPanel(canvasPanel, gameBoard);
        ControlPanel controlPanel = new ControlPanel(canvasPanel, gameBoard, this);

        BorderPane mainFrame = new BorderPane();
        mainFrame.setTop(configPanel);
        mainFrame.setCenter(canvasPanel);
        mainFrame.setBottom(controlPanel);
        BorderPane.setMargin(canvasPanel, new Insets(10, 10, 10, 10));

        Scene scene = new Scene(mainFrame);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Coloring Game");
        primaryStage.setMinWidth(800);
        primaryStage.setMinHeight(700);
    }

    public void saveGame() {
        GameData gameData = new GameData(gameBoard, canvasPanel.getPlayerToMove());
        if(gameBoard.getPlayer1() == null){
            return;
        }
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Game");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Serialized Object (*.ser)", "*.ser"));
        File file = fileChooser.showSaveDialog(null);
        if(file != null){
            try{
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
                objectOut.writeObject(gameData);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadGame(){
        gameBoard.resetGame();
        canvasPanel.render();
        canvasPanel.setTurnText("Player to chose: ");
        canvasPanel.startListening();
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Select your game data file");
        File file = fileChooser.showOpenDialog(null);
        if(file != null){
            try{
                FileInputStream fileIn = new FileInputStream(file);
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                GameData gameData = (GameData) objectIn.readObject();

                gameBoard.setLines(gameData.getLines());
                gameBoard.setDots(gameData.getDots());

                Player player1 = new Player(gameData.getPlayer1Name(), Color.BLUE, gameData.getPlayer1Lines());
                Player player2 = new Player(gameData.getPlayer2Name(), Color.RED, gameData.getPlayer2Lines());
                configPanel.setPlayer1TextField(gameData.getPlayer1Name());
                configPanel.setPlayer2TextField(gameData.getPlayer2Name());
                gameBoard.setPlayer1(player1);
                gameBoard.setPlayer2(player2);

                canvasPanel.setGameBoard(gameBoard);
                canvasPanel.setPlayerToMove(gameData.getPlayerToMove());
                canvasPanel.load(gameBoard, player1, player2);

                System.out.println("Game loaded");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void startGame(){
        primaryStage.show();
    }

}