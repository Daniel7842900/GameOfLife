package com.example.gol.logic.entity;

import com.example.gol.presentation.Cell;
import com.example.gol.presentation.World;

import java.util.ArrayList;
import java.util.List;

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
