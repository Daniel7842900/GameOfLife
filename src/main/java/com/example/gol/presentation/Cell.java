package com.example.gol.presentation;

import com.example.gol.logic.entity.*;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Pane {
    private int x = 0;
    private int y = 0;
    private LifeForm lifeForm;

    public Cell(Coordinate coordinate) {
        Rectangle rectangle = new Rectangle(40, 40);

        // Set the position
        setTranslateY(coordinate.y);
        setTranslateX(coordinate.x);

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
        if(lifeForm != null) {
            // Remove the rectangle shape before we create a new one
            this.getChildren().clear();

            // Create a new rectangle
            Rectangle rectangle = new Rectangle(40, 40);

            // Set the border of the rectangle
            rectangle.setStroke(Color.BLACK);

            if(lifeForm.getClass().equals(Herbivore.class)) {
                rectangle.setFill(Color.YELLOW);
            } else if(lifeForm.getClass().equals(Plant.class)) {
                rectangle.setFill(Color.GREEN);
            } else if(lifeForm.getClass().equals(Carnivore.class)) {
                rectangle.setFill(Color.RED);
            } else if(lifeForm.getClass().equals(Omnivore.class)) {
                rectangle.setFill(Color.BLUE);
            }

            // Add rectangle node to a cell
            getChildren().add(rectangle);
        }
    }

    protected static class Coordinate {
        private int x = 0, y = 0;

        protected Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
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
}
