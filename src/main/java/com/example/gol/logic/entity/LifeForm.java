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

    }

    public void die() {

    }

    public void move() {

    }

    public abstract void performAction();

    public Cell chooseCell(List<Cell> availableCells) {
        Random rand = new Random();

        // Pick random number from 0 to availableCells.size - 1
        int randomPick = rand.nextInt(availableCells.size());

        System.out.println(randomPick);

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
