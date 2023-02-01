package com.example.gol.logic.entity;

import com.example.gol.presentation.Cell;
import com.example.gol.presentation.World;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class LifeForm {
    private int turnToDeath = 5;

    protected Cell cell;

    private World world;

    private String color;

    public String getColor() {
        return color;
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

}
