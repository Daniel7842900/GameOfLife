package com.example.gol.application;

import com.example.gol.logic.entity.LifeForm;
import com.example.gol.presentation.Cell;
import com.example.gol.presentation.World;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class GameOfLife {

    public void startGame(Stage stage) {
        World world = new World();

        GridPane root = world.createWorld(stage);

        Scene scene = new Scene(root);
        stage.setTitle("Game Of Life!");
        scene.getStylesheets().add(getClass().getResource("/com/example/gol/GameOfLifeStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();

        takeTurn(scene, world);

    }

    private void takeTurn(Scene scene, World world) {
        scene.addEventHandler(MouseEvent.MOUSE_PRESSED, new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                System.out.println("mouse pressed");
                Cell[][] map = world.getMap();
                int rows = map.length, columns = map[0].length;
                System.out.println(rows + " " + columns);

                for (int i = 0; i < columns; i++) {
                    for (int j = 0; j < rows; j++) {
                        // invoke life form to check neighbor and take action (move)
                        LifeForm lifeForm = map[i][j].getLifeForm();

//                        System.out.println("i: " + i + " j: " + j);
                        if(lifeForm != null && !lifeForm.isMoved()) {
//                            System.out.println("lifeForm is " + lifeForm);
                            lifeForm.performAction();

                        }
                    }
                }
                world.updateMap();
            }
        });
    }

    // Get the life forms and perform move

}
