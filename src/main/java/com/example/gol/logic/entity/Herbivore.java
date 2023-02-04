package com.example.gol.logic.entity;

import com.example.gol.application.RandomGenerator;
import com.example.gol.presentation.Cell;

import java.util.ArrayList;
import java.util.List;

public class Herbivore extends LifeForm {
    private String color = "YELLOW";

    public Herbivore(Cell cell) {
//        super();
        super.cell = cell;
    }

    @Override
    public void performAction() {
        System.out.println("performing performAction in Herbivore...");
        // move first and then give birth
        move();
//        giveBirth();
    }

    @Override
    public void move() {
        System.out.println("Herbivore moving...");
        List<Cell> allNeighbors = this.getCell().getNeighborCells();

        if(allNeighbors == null) return;

        // Get eligible neighbors among available cells
        List<Cell> eligibleNeighbors = this.getEligibleNeighbors(allNeighbors);
        System.out.println(eligibleNeighbors);

        // Get current Cell
        Cell curCell = this.getCell();

        // Choose a cell among eligible neighbor cells
        Cell chosenCell = super.chooseCell(eligibleNeighbors);

        // Set a chosen cell (new cell) in this life form
        this.setCell(chosenCell);
        // Set a life form in the chosen cell (new cell)
        chosenCell.setLifeForm(this);

        // Make current cell as empty since life form moved
        curCell.setLifeForm(null);

        // Set this life form's moved status as true
        this.setMoved(true);
    }

    /**
     * Get a list of neighbor cells with a higher precedence.
     * If there are cells that a life form can eat, then it chooses over that list
     * over a list of empty cells.
     *
     * @param allNeighbors
     * @return List<Cell>
     */
    private List<Cell> getEligibleNeighbors(List<Cell> allNeighbors) {
        List<Cell> eligibleNeighbors = new ArrayList<>();
        List<Cell> edibleNeighbors = new ArrayList<>();
        List<Cell> emptyNeighbors = new ArrayList<>();

        // Distribute edible neighbors and empty neighbors
        for (Cell c:
                allNeighbors) {
            LifeForm lifeForm = c.getLifeForm();
            if(lifeForm == null) {
                emptyNeighbors.add(c);
            } else {
                if(lifeForm == null || lifeForm.getClass().equals(Plant.class))  {
                    edibleNeighbors.add(c);
                }
            }
        }

        if(edibleNeighbors.size() >= emptyNeighbors.size()) {
            eligibleNeighbors = edibleNeighbors;
        } else {
            eligibleNeighbors = emptyNeighbors;
        }

        return eligibleNeighbors;
    }



    public String getColor() {
        return color;
    }
}
