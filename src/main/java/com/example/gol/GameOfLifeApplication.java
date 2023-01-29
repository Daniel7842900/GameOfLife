package com.example.gol;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOfLifeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        World world = new World();

        world.createWorld(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}