package com.example.gol.logic.entity;

import com.example.gol.presentation.Cell;

import java.util.List;

public class Plant extends LifeForm {
    String color = "GREEN";

    public Plant(Cell cell) {
        super.cell = cell;
    }

    @Override
    public void giveBirth() {

    }

    @Override
    public void performAction() {
        System.out.println("performing performAction in Plant...");
        List<Cell> neighbors = this.getCell().getNeighborCells();

        System.out.println(super.getCell().getRow() + " " + super.getCell().getCol());

        for (Cell c:
             neighbors) {
            System.out.println(" row: " + c.getRow() + "col: " + c.getCol());
        }
    }

    public String getColor() {
        return this.color;
    }

}
