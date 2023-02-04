package com.example.gol.presentation;

import com.example.gol.logic.entity.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * Presentation layer for a cell.
 * A cell contains a life form inside
 */
public class Cell extends Pane {
    private int row = 0;
    private int col = 0;
    private LifeForm lifeForm;
    private World world;
    private Cell[] neighborCells;

    public Cell(World world, int row, int col) {
        Rectangle rectangle = new Rectangle(40, 40);

        // Set the position
        setTranslateY(row);
        setTranslateX(col);
        this.row = row;
        this.col = col;
        this.world = world;

        // Set background color and border
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        // Add rectangle node to a cell
        getChildren().add(rectangle);
    }

    /**
     * Draw (color) a cell based on life form provided.
     * Remove the current one and re-create a rectangle
     *
     * @param lifeForm
     */
    protected void drawCell(LifeForm lifeForm) {
        // Remove the rectangle shape before we create a new one
        this.getChildren().clear();

        // Create a new rectangle
        Rectangle rectangle = new Rectangle(40, 40);

        // Set the border of the rectangle
        rectangle.setStroke(Color.BLACK);

        if(lifeForm != null) {
            if(lifeForm.getClass().equals(Herbivore.class)) {
                rectangle.setFill(Color.YELLOW);
            } else if(lifeForm.getClass().equals(Plant.class)) {
                rectangle.setFill(Color.GREEN);
            } else if(lifeForm.getClass().equals(Carnivore.class)) {
                rectangle.setFill(Color.RED);
            } else if(lifeForm.getClass().equals(Omnivore.class)) {
                rectangle.setFill(Color.BLUE);
            }
        } else {
            rectangle.setFill(Color.WHITE);
        }

        // Add rectangle node to a cell
        getChildren().add(rectangle);
    }

    /**
     * Find neighbor cells within the grid.
     * Look for the cells that are vertical, horizontal, and diagonal.
     * Loop through the cells top -> down, left -> right
     *
     * @return
     */
    public List<Cell> getNeighborCells() {
        List<Cell> neighbors = new ArrayList<>();
        if(this.getLifeForm() != null) {
            Cell[][] map = world.getMap();

            // Get row and col from the current cell
            int row = this.getRow();
            int col = this.getCol();

            for(int c = -1; c <= 1; c++) {
                for(int r = -1; r <= 1; r++) {
                    // Do not add cell itself as a neighbor
                    if(c == 0 && r == 0) continue;

                    // Out of bound from the leftmost and rightmost column, break
                    if((col == 0 && c == -1) || (col == map[0].length - 1 && c == 1)) break;

                    // Out of bound from the top and bottom, skip that cell
                    if((row == 0 && r == -1) || (row == map.length - 1 && r == 1)) continue;

                    // Add neighbor cell to a list
                    neighbors.add(map[row+r][col+c]);
                }
            }
        }

        return neighbors;
    }

    protected void addLife(LifeForm lifeForm) {
        // Set life form in a cell
        setLifeForm(lifeForm);

        // Draw life form in a cell
        drawCell(lifeForm);
    }

    public LifeForm getLifeForm() {
        return this.lifeForm;
    }

    public void setLifeForm(LifeForm lifeForm) {
        this.lifeForm = lifeForm;
    }

    public int getRow() {
        return row;
    }

    public int getCol() {
        return col;
    }

    public World getWorld() {
        return world;
    }
}
