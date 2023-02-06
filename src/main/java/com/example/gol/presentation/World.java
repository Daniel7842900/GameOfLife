package com.example.gol.presentation;

import com.example.gol.application.RandomGenerator;
import com.example.gol.logic.entity.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
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

    private int rows = 6, columns = 6;

    private GridPane createRoot() {
        root = new GridPane();

        return root;
    }

    /**
     * Create a cell and add it to 2D array and the grid
     * Loop through the cells top -> down, left -> right
     *
     * @param root
     */
    private void createGrid(GridPane root) {
        System.out.println("creating grid...");
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
                // Add a cell to 2d Cell array
                map[j][i] = new Cell(this, j, i);

                // Add a cell to gridpane to display
                root.add(map[j][i], i, j);
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
        System.out.println("populating life forms...");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                int val = RandomGenerator.nextNumber(99);

                // Add a cell to 2d Cell array
                Cell cell = map[j][i];
                LifeForm lifeForm = null;

                if(val >= 80) {
                    lifeForm = new Herbivore(cell);
                } else if(val >= 60) {
//                    lifeForm = new Plant(cell);
                } else if(val >= 50) {
                    lifeForm = new Carnivore(cell);
                } else if(val >= 45) {
                    lifeForm = new Omnivore(cell);
                }

                cell.addLife(lifeForm);
//                System.out.println("j: " + j + " i: " + i);
//                System.out.println("life form in populate: " + cell.getLifeForm());
            }
        }
    }

    /**
     * Update the map (grid pane) with the updated cells that contains new life form.
     * This method is called after a mouse click.
     *
     */
    public void updateMap() {
        System.out.println("updating map in world...");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                // Get the cell located at index j and i
                Cell cell = map[j][i];

                // Get the life form in the cell
                LifeForm lifeForm = cell.getLifeForm();

//                System.out.println("lifeform at row: " + j + " col: " + i);
//                System.out.println(lifeForm);

                // Draw the life form
                cell.drawCell(lifeForm);
            }
        }

        resetMoveStatus();
    }

    private void resetMoveStatus() {
        System.out.println("Resetting moved status for life forms...");
        for (int i = 0; i < columns; i++) {
            for (int j = 0; j < rows; j++) {
                // Get the cell located at index j and i
                Cell cell = map[j][i];

                // Get the life form in the cell
                LifeForm lifeForm = cell.getLifeForm();

//                System.out.println("lifeform at row: " + j + " col: " + i);
//                System.out.println(lifeForm);

                // Draw the life form
                if(lifeForm != null) {
                    lifeForm.setMoved(false);
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
