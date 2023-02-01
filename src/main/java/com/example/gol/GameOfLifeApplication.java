package com.example.gol;

import com.example.gol.application.GameOfLife;
import com.example.gol.presentation.World;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class GameOfLifeApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        GameOfLife gameOfLife = new GameOfLife();
        gameOfLife.startGame(stage);
    }

    public static void main(String[] args) {
        launch();
    }
}