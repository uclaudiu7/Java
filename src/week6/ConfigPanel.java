package com.example.week6;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ConfigPanel extends StackPane {
    private Label dotsLabel;
    private Label linesLabel;
    private Label player1Label;
    private Label player2Label;
    private TextField player1TextField;
    private TextField player2TextField;
    private Spinner<Integer> dotsSpinner;
    private ChoiceBox<Double> linesChoiceBox;
    private Button newGameButton;
    private HBox hbox;
    private CanvasPanel canvasPanel;

    public ConfigPanel(CanvasPanel canvasPanel, GameBoard gameBoard) {
        this.canvasPanel = canvasPanel;

        player1Label = new Label("Player 1:");
        player2Label = new Label("Player 2:");
        player1TextField = new TextField();
        player2TextField = new TextField();
        dotsLabel = new Label("Number of dots:");
        linesLabel = new Label("Line probability:");
        dotsSpinner = new Spinner<>(5, 30, 5);
        linesChoiceBox = new ChoiceBox<>();
        newGameButton = new Button("Create New Game!");
        hbox = new HBox();

        player1TextField.setMaxWidth(100);
        player2TextField.setMaxWidth(100);

        dotsLabel.setTextFill(Color.BLACK);
        linesLabel.setTextFill(Color.BLACK);

        SpinnerValueFactory<Integer> dotsValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 30, 5);
        dotsSpinner.setValueFactory(dotsValueFactory);
        dotsSpinner.setMaxWidth(80);

        linesChoiceBox.getItems().addAll(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0);
        linesChoiceBox.setValue(0.1);
        linesChoiceBox.setMaxWidth(80);

        hbox.getChildren().addAll(player1Label, player1TextField, player2Label, player2TextField, dotsSpinner, linesLabel, linesChoiceBox, newGameButton);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        setPadding(new Insets(10, 10, 10, 10));
        setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(Color.web("#f0ecec"), CornerRadii.EMPTY, Insets.EMPTY)));

        getChildren().addAll(hbox);

        newGameButton.setOnAction(e -> {
            int numDots = dotsSpinner.getValue();
            double lineProbability = linesChoiceBox.getValue();
            String player1Name = player1TextField.getText();
            String player2Name = player2TextField.getText();
            gameBoard.newGame(numDots, lineProbability, player1Name, player2Name);
            canvasPanel.render();
            canvasPanel.setTurnText("Player to chose: " + gameBoard.getPlayer1().getName());
            canvasPanel.startListening();
        });
    }
}