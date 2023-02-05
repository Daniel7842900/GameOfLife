package com.example.gol.logic.entity;

import com.example.gol.presentation.Cell;
import com.example.gol.presentation.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Superclass for life forms
 * LifeForm does everything it can do in one turn, then the next cell takes turn.
 * i.e. Herbivore moves and reproduces. Then whatever cell comes next, will act accordingly.
 */
public abstract class LifeForm {
    private int turnToDeath = 5;
    protected Cell cell;
    private World world;
    private String color;
    private boolean moved = false;

    public void test() {
        System.out.println("test");
    }



    public void eat() {

    }

    public void giveBirth() {
        System.out.println("Entering Life Form giveBirth...");
        List<Cell> allNeighbors = this.getCell().getNeighborCells();
        List<Cell> availableNeighbors = new ArrayList<>();

        int herbCount = 0;
        int emptyCellCount = 0;
        int plantCount = 0;

        for (Cell c:
                allNeighbors) {
            LifeForm lifeForm = c.getLifeForm();
            if(lifeForm == null) {
                emptyCellCount++;
                availableNeighbors.add(c);
            } else if(lifeForm.getClass().equals(Herbivore.class)) {
                herbCount++;
            } else if(lifeForm.getClass().equals(Plant.class)) {
                plantCount++;
            }
        }

        if(herbCount >= 1 && emptyCellCount >= 2 && plantCount >= 2) {
            System.out.println("Herbivore giving birth...");
            Cell chosenCell = chooseCell(availableNeighbors);
            chosenCell.setLifeForm(new Herbivore(chosenCell));
            chosenCell.getLifeForm().setMoved(true);
        }
    }

    public void die() {


    }

    public void move() {
        System.out.println("Life form moving...");
        List<Cell> allNeighbors = this.getCell().getNeighborCells();

        // If there is no neighbor cells, don't move
        if(allNeighbors.size() == 0) return;

        // Get eligible neighbors among available cells
        List<Cell> eligibleNeighbors = this.getCell().getEligibleNeighbors(allNeighbors);

        // If there is no eligible cells, don't move
        if(eligibleNeighbors.size() == 0) return;

        // Get current Cell
        Cell curCell = this.getCell();

        // Choose a cell among eligible neighbor cells
        Cell chosenCell = chooseCell(eligibleNeighbors);

        // Set a chosen cell (new cell) in this life form
        this.setCell(chosenCell);
        // Set a life form in the chosen cell (new cell)
        chosenCell.setLifeForm(this);

        // Make current cell as empty since life form moved
        curCell.setLifeForm(null);

        // Set this life form's moved status as true
        this.setMoved(true);
    }

    public abstract void performAction();

    public Cell chooseCell(List<Cell> availableCells) {
        Random rand = new Random();
//        System.out.println("neighbor size: " + availableCells.size());
        // Pick random number from 0 to availableCells.size - 1
        int randomPick = rand.nextInt(availableCells.size());

//        System.out.println(randomPick);

        // Get the cell index at randomPick
        Cell chosenCell = availableCells.get(randomPick);

        return chosenCell;
    }

    public int getTurnToDeath() {
        return this.turnToDeath;
    }

    public void setTurnToDeath(int turn) {
        this.turnToDeath = turn;
    }

    public Cell getCell() {
        return this.cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public String getColor() {
        return color;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public boolean isMoved() {
        return moved;
    }
}
