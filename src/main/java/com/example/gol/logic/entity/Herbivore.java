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

    /**
     * Life forms move first and then give birth after.
     */
    @Override
    public void performAction() {
        System.out.println("performing performAction in Herbivore...");
        move();
        giveBirth();
    }

//    @Override
//    public void move() {
//        System.out.println("Herbivore moving...");
//        List<Cell> allNeighbors = this.getCell().getNeighborCells();
//
//        // If there is no neighbor cells, don't move
//        if(allNeighbors.size() == 0) return;
//
//        // Get eligible neighbors among available cells
//        List<Cell> eligibleNeighbors = this.getEligibleNeighbors(allNeighbors);
//        System.out.println(eligibleNeighbors);
//
//        // If there is no eligible cells, don't move
//        if(eligibleNeighbors.size() == 0) return;
//
//        // Get current Cell
//        Cell curCell = this.getCell();
//
//        // Choose a cell among eligible neighbor cells
//        Cell chosenCell = super.chooseCell(eligibleNeighbors);
//
//        // Set a chosen cell (new cell) in this life form
//        this.setCell(chosenCell);
//        // Set a life form in the chosen cell (new cell)
//        chosenCell.setLifeForm(this);
//
//        // Make current cell as empty since life form moved
//        curCell.setLifeForm(null);
//
//        // Set this life form's moved status as true
//        this.setMoved(true);
//    }

//    @Override
//    public void giveBirth() {
//        System.out.println("Entering Herbivore giveBirth...");
//        List<Cell> allNeighbors = this.getCell().getNeighborCells();
//        List<Cell> availableNeighbors = new ArrayList<>();
//
//        int herbCount = 0;
//        int emptyCellCount = 0;
//        int plantCount = 0;
//
//        for (Cell c:
//             allNeighbors) {
//            LifeForm lifeForm = c.getLifeForm();
//            if(lifeForm == null) {
//                emptyCellCount++;
//                availableNeighbors.add(c);
//            } else if(lifeForm.getClass().equals(Herbivore.class)) {
//                herbCount++;
//            } else if(lifeForm.getClass().equals(Plant.class)) {
//                plantCount++;
//            }
//        }
//
//        if(herbCount >= 1 && emptyCellCount >= 2 && plantCount >= 2) {
//            System.out.println("Herbivore giving birth...");
//            Cell chosenCell = super.chooseCell(availableNeighbors);
//            chosenCell.setLifeForm(new Herbivore(chosenCell));
//            chosenCell.getLifeForm().setMoved(true);
//        }
//    }

    public String getColor() {
        return color;
    }
}
