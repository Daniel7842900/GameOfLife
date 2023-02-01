package com.example.gol.presentation;

import com.example.gol.application.RandomGenerator;
import com.example.gol.logic.entity.*;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
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

    private int rows = 2, columns = 2;

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
        // Note that we are filling up cells columns first, then rows
        // (we are filling up cells into grid from top to bottom starting from column 0
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                // Add a cell to 2d Cell array
                map[j][i] = new Cell(this, j, i);
                /**
                 * cell
                 * cell
                 * cell
                 * cell
                 *
                 *
                 */

                // Add a cell to gridpane to display
                root.add(map[j][i], i, j);
                // i = 0 j = 0
                // i = 0 j = 1
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

                // i = 0 j = 0
                // i = 0 j = 1
                // Add a cell to 2d Cell array
                Cell cell = map[j][i];
                LifeForm lifeForm = null;

                if(val >= 80) {
                    lifeForm = new Herbivore(cell);
                } else if(val >= 60) {
                    lifeForm = new Plant(cell);
                } else if(val >= 50) {
                    lifeForm = new Carnivore();
                } else if(val >= 45) {
                    lifeForm = new Omnivore();
                }

                cell.addLife(lifeForm);
                System.out.println("j: " + j + " i: " + i);
                System.out.println("life form in populate: " + cell.getLifeForm());
            }
        }
    }

    /**
     * Create a world.
     * Create a root pane and create a grid inside the root pane
     *
     * @param stage
     */
    public GridPane createWorld(Stage stage) {
        GridPane root = createRoot();
        createGrid(root);

        return root;
    }

    public Cell[][] getMap() {
        return this.map;
    }

    public void setMap(Cell[][] map) {
        this.map = map;
    }
}
