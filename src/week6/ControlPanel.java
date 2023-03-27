package com.example.week6;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class ControlPanel extends HBox {
    private Button loadButton;
    private Button saveButton;
    private Button resetButton;
    private Button exitButton;

    public ControlPanel() {
        setPadding(new Insets(10, 10, 10, 10));
        setSpacing(10);
        setAlignment(Pos.CENTER);
        setBackground(new Background(new BackgroundFill(Color.web("#f0ecec"), CornerRadii.EMPTY, Insets.EMPTY)));

        loadButton = new Button("Load");
        saveButton = new Button("Save");
        resetButton = new Button("Reset");
        exitButton = new Button("Exit");

        getChildren().addAll(loadButton, saveButton, resetButton, exitButton);
    }
}
