package com.example.gol;

import com.example.gol.presentation.World;
import javafx.application.Application;
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