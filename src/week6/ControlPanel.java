package com.example.week6;

import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;

import javafx.embed.swing.SwingFXUtils;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class ControlPanel extends HBox {
    private CanvasPanel canvasPanel;
    private GameBoard gameBoard;
    private Button loadButton;
    private Button saveButton;
    private Button exportButton;
    private Button resetButton;
    private Button exitButton;

    public ControlPanel(CanvasPanel canvasPanel, GameBoard gameBoard, Game game) {
        this.canvasPanel = canvasPanel;
        this.gameBoard = gameBoard;
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(10);
        setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(Color.web("#f0ecec"), CornerRadii.EMPTY, Insets.EMPTY)));

        loadButton = new Button("Load");
        saveButton = new Button("Save");
        exportButton = new Button("Export");
        resetButton = new Button("Reset");
        exitButton = new Button("Exit");

        loadButton.setOnAction(event -> handleLoadButton(game));
        saveButton.setOnAction(event -> handleSaveButton(game));
        exportButton.setOnAction(this::handleExportButton);
        resetButton.setOnAction(this::handelResetButton);
        exitButton.setOnAction(this::handleExitButton);

        getChildren().addAll(loadButton, saveButton, exportButton, resetButton, exitButton);

    }

    private void handleLoadButton(Game game){
        game.loadGame();
    }

    private void handleSaveButton(Game game){
        game.saveGame();
    }

    private void handleExportButton(ActionEvent event) {
        Canvas canvas = canvasPanel.getCanvas();

        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Game as PNG");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG files (*.png)", "*.png"));
        File selectedFile = fileChooser.showSaveDialog(null);

        if (selectedFile != null) {
            try {
                WritableImage writableImage = new WritableImage((int) canvas.getWidth(), (int) canvas.getHeight());
                SnapshotParameters sp = new SnapshotParameters();
                canvas.snapshot(sp, writableImage);

                BufferedImage bufferedImage = SwingFXUtils.fromFXImage(writableImage, null);
                ImageIO.write(bufferedImage, "png", selectedFile);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

    private void handelResetButton(ActionEvent event) {
        gameBoard.resetGame();
        canvasPanel.render();
        canvasPanel.setTurnText("Player to chose: " + gameBoard.getPlayer1().getName());
        canvasPanel.startListening();
    }

    private void handleExitButton(ActionEvent event) {
        System.exit(0);
    }

}
