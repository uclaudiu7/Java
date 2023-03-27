package com.example.week6;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class ConfigPanel extends StackPane {
    private Label dotsLabel;
    private Label linesLabel;
    private Spinner<Integer> dotsSpinner;
    private ChoiceBox<Double> linesChoiceBox;
    private Button newGameButton;
    private HBox hbox;
    private CanvasPanel canvasPanel;

    public ConfigPanel(CanvasPanel canvasPanel) {
        this.canvasPanel = canvasPanel;

        dotsLabel = new Label("Number of dots:");
        linesLabel = new Label("Line probability:");
        dotsSpinner = new Spinner<>(5, 30, 5);
        linesChoiceBox = new ChoiceBox<>();
        newGameButton = new Button("Create New Game!");
        hbox = new HBox();

        dotsLabel.setTextFill(Color.BLACK);
        linesLabel.setTextFill(Color.BLACK);

        SpinnerValueFactory<Integer> dotsValueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(5, 30, 5);
        dotsSpinner.setValueFactory(dotsValueFactory);
        dotsSpinner.setMaxWidth(80);

        linesChoiceBox.getItems().addAll(0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1.0);
        linesChoiceBox.setValue(0.1);
        linesChoiceBox.setMaxWidth(80);

        hbox.getChildren().addAll(dotsLabel, dotsSpinner, linesLabel, linesChoiceBox, newGameButton);
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);

        setPadding(new Insets(10, 10, 10, 10));
        setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(Color.web("#f0ecec"), CornerRadii.EMPTY, Insets.EMPTY)));

        getChildren().addAll(hbox);

        newGameButton.setOnAction(e -> {
            int numDots = dotsSpinner.getValue();
            double lineProbability = linesChoiceBox.getValue();
            canvasPanel.drawDots(numDots, lineProbability);
        });
    }
}