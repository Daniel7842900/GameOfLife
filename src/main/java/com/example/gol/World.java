package com.example.gol;

import javafx.scene.Scene;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class World {
    private GridPane root;

    private GridPane createRoot() {
        root = new GridPane();

        return root;
    }

    private void createGrid(GridPane root) {
        int rows = 5, columns = 5;

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
                Pane pane = new Pane();
                pane.getStyleClass().add("game-grid-cell");
                if (i == 0) {
                    pane.getStyleClass().add("first-column");
                }
                if (j == 0) {
                    pane.getStyleClass().add("first-row");
                }
                root.add(pane, i, j);
            }
        }
    }

    /**
     * Create a world.
     * Create a root pane and create a grid inside the root pane
     *
     * @param stage
     */
    protected void createWorld(Stage stage) {
        GridPane root = createRoot();
        createGrid(root);

        Scene scene = new Scene(root);
        stage.setTitle("Game Of Life!");
        scene.getStylesheets().add(getClass().getResource("GameOfLifeStyle.css").toExternalForm());
        stage.setScene(scene);
        stage.show();
    }
}
