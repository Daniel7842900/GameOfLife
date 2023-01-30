package com.example.gol.presentation;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Cell extends Pane {

    private int x = 0;
    private int y = 0;

    public Cell(Coordinate coordinate) {
        Rectangle rectangle = new Rectangle(40, 40);

        // Set the position
        setTranslateY(coordinate.y);
        setTranslateX(coordinate.x);

        // Set background color and border
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.WHITE);

        // Add rectangle node to a Pane
        getChildren().add(rectangle);
    }

    protected static class Coordinate {
        private int x = 0, y = 0;
        protected Coordinate(int y, int x) {
            this.y = y;
            this.x = x;
        }
    }
}
