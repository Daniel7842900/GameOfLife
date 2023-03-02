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
 *
 * @Author Daniel Lim
 */
public abstract class LifeForm {
    private int turnToDeath = 5;
    private int hungryLevel = 0;
    private boolean isAlive = true;
    protected Cell cell;
    private boolean moved = false;

    public void eat() {

    }

    public abstract void performAction();

    protected abstract int countEdible(List<Cell> neighbors);

    protected abstract LifeForm createLife(Cell cell);

    /**
     * Method to give a birth.
     * Count the numbers of mate, empty, and food in neighbor cells.
     * If the condition is met, give a birth to a life form.
     *
     * @param numMates
     * @param numEmpty
     * @param numFood
     */
    public void giveBirth(int numMates, int numEmpty, int numFood) {
        System.out.println("Entering Life Form giveBirth...");
        List<Cell> allNeighbors = this.getCell().getNeighborCells();
        List<Cell> availableNeighbors = new ArrayList<>();

        // Count number of mates and number of empty cells
        for (Cell c:
                allNeighbors) {
            LifeForm lifeForm = c.getLifeForm();
            if(lifeForm == null) {
                numEmpty--;
                availableNeighbors.add(c);
            } else if(lifeForm.getClass().equals(this.getClass())) {
                numMates--;
            }
        }

        // Get the number of food cells
        int edibleFood = this.countEdible(allNeighbors);

        // Condition to give a birth
        if(numEmpty <= 0 && numMates <= 0 && (numFood - edibleFood) <= 0) {
            System.out.println("Life form giving birth...");
            System.out.println("original life form is at: " + this.getCell().getRow() + " and " + this.getCell().getCol());
            Cell chosenCell = chooseCell(availableNeighbors);
            System.out.println("chosen life form is at: " + chosenCell.getRow() + " and " + chosenCell.getCol());

            // Create a new life form accordingly
            LifeForm newLifeForm = createLife(chosenCell);

            // Set the new life form in the chosen cell and mark as moved
            chosenCell.setLifeForm(newLifeForm);
            chosenCell.getLifeForm().setMoved(true);
        }
    }

    /**
     * Kill a life form if it couldn't eat food within turns.
     */
    public void die() {
        // Make current cell as empty since life form moved
        this.getCell().setLifeForm(null);
    }

    /**
     * Method to move a life form.
     * Finds available neighbor cells depending on the current cell's life form.
     * Randomly choose a cell among available neighbor cells and set the life form
     * in that cell. Also, set cell info in the life form as well.
     * The current cell will be empty after the life form moves.
     *
     */
    public void move() {
        System.out.println("Life form moving...");

        if(!this.isAlive()) {
            // Kill the life form if it didn't eat within turns
            die();
            return;
        }

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

        if(chosenCell.getLifeForm() == null) {
            // Increment the hungry level
            this.setHungryLevel(this.getHungryLevel() + 1);
        } else {
            // Reset the hungry level
            this.setHungryLevel(0);
        }

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
     * Randomly choose a cell among provided available cells.
     * Use RandomGenerator to generate a random number.
     *
     * @param availableCells
     * @return
     */
    public Cell chooseCell(List<Cell> availableCells) {
        Random rand = new Random();

        // Pick random number from 0 to availableCells.size - 1
        int randomPick = rand.nextInt(availableCells.size());

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

    public int getHungryLevel() {
        return hungryLevel;
    }

    public void setHungryLevel(int hungryLevel) {
        this.hungryLevel = hungryLevel;
    }

    /**
     * Check hungry level each turn.
     * If it didn't eat within turns, set the isAlive flag to false.
     *
     * @return boolean
     */
    public boolean isAlive() {
        if(this.getHungryLevel() < this.getTurnToDeath()) {
            this.setAlive(true);
        } else {
            this.setAlive(false);
        }
        return this.isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = alive;
    }

    public Cell getCell() {
        return this.cell;
    }

    public void setCell(Cell cell) {
        this.cell = cell;
    }

    public void setMoved(boolean moved) {
        this.moved = moved;
    }

    public boolean isMoved() {
        return moved;
    }
}
