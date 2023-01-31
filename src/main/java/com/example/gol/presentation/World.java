package com.example.gol.presentation;

import com.example.gol.application.RandomGenerator;
import com.example.gol.logic.entity.*;
import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * Presentation Layer.
 * World is made out of cells.
 */
public class World {
    // Presentation layer grid
    private GridPane root;

    // 2D array to store cells for logics
    private Cell[][] map;

    private int rows = 5, columns = 5;

    private GridPane createRoot() {
        root = new GridPane();

        return root;
    }

    private void createGrid(GridPane root) {
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

        // Create a cell and add it to 2D array and the grid
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                Cell cell = new Cell(new Cell.Coordinate(i,j));

                // Add a cell to 2d Cell array
                map[i][j] = cell;

                // Add a cell to gridpane to display
                root.add(cell, j, i);
            }
        }

        // Populate lifeforms using random generator
        initPopulate();
    }

    /**
     * Populate lifeforms using random generator
     *
     */
    private void initPopulate() {
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                int val = RandomGenerator.nextNumber(99);

                // Add a cell to 2d Cell array
                Cell cell = map[i][j];

                LifeForm lifeForm = null;

                if(val >= 80) {
                    lifeForm = new Herbivore();
                } else if(val >= 60) {
                    lifeForm = new Plant();
                } else if(val >= 50) {
                    lifeForm = new Carnivore();
                } else if(val >= 45) {
                    lifeForm = new Omnivore();
                }

                cell.addLife(lifeForm);
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
