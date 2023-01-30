package com.example.gol.presentation;

import com.example.gol.application.RandomGenerator;
import com.example.gol.logic.entity.Plant;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class World {
    private GridPane root;

    private Cell[][] map;

    private GridPane createRoot() {
        root = new GridPane();

        return root;
    }

    private void createGrid(GridPane root) {
        int rows = 5, columns = 5;
        map = new Cell[rows][columns];

        RandomGenerator.reset();

        for(int i = 0; i < columns; i++) {
            ColumnConstraints column = new ColumnConstraints(40);
            root.getColumnConstraints().add(column);
        }

        for(int i = 0; i < rows; i++) {
            RowConstraints row = new RowConstraints(40);
            root.getRowConstraints().add(row);
        }

        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Cell cell = new Cell(new Cell.Coordinate(i,j));
                int val = RandomGenerator.nextNumber(99);

                // Add a cell to 2d Cell array
                map[i][j] = cell;

                // Add a cell to gridpane to display
                root.add(cell, j, i);

                if(val >= 80) {
                    Plant plant = new Plant();
                    map[i][j].addLife(plant);
                    map[i][j].drawCell(plant);
                } else if(val >= 60) {
//                    map[i][j].drawCell(plant);
                } else if(val >= 50) {

                } else if(val >= 45) {

                }
            }
        }
    }

    /**
     * Create a world.
     * Create a root pane and create a grid inside the root pane
     *
     * @param stage
     */
    public void createWorld(Stage stage) {
        GridPane root = createRoot();
        createGrid(root);

        Scene scene = new Scene(root);
        stage.setTitle("Game Of Life!");
        scene.getStylesheets().add(getClass().getResource("/com/example/gol/GameOfLifeStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
