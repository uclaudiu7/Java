package com.example.week6;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Canvas canvas = new Canvas(700, 500);
        CanvasPanel canvasPanel = new CanvasPanel(canvas);
        ConfigPanel configPanel = new ConfigPanel(canvasPanel);
        ControlPanel controlPanel = new ControlPanel();

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
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}