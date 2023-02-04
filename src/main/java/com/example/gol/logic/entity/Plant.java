package com.example.gol.logic.entity;

import com.example.gol.presentation.Cell;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Plant extends LifeForm {
    String color = "GREEN";

    public Plant(Cell cell) {
        super.cell = cell;
    }

    @Override
    public void giveBirth() {
        System.out.println("Giving birth Plant...");
        List<Cell> neighbors = this.getCell().getNeighborCells();
        List<Cell> availableNeighbors = new ArrayList<>();

        System.out.println(super.getCell().getRow() + " " + super.getCell().getCol());

        int countPlant = 0;
        int countEmpty = 0;

        for (Cell c:
                neighbors) {
            System.out.println(" row: " + c.getRow() + "col: " + c.getCol());
            LifeForm lifeForm = c.getLifeForm();
            if(!lifeForm.isMoved()) {
                if(lifeForm == null)  {
                    countEmpty++;
                    availableNeighbors.add(c);
                } else if(lifeForm.getClass().equals(Plant.class)) {
                    countPlant++;
                }
            }
        }

        System.out.println("countPlant: " + countPlant);
        System.out.println("countEmpty: " + countEmpty);

        if(countPlant >= 2 && countEmpty >= 3) {
            System.out.println("seed!!!!");
            Cell chosenCell = super.chooseCell(availableNeighbors);
            System.out.println(chosenCell.getRow() + " " + chosenCell.getCol());
            chosenCell.setLifeForm(new Plant(chosenCell));
            chosenCell.getLifeForm().setMoved(true);

            // Set moved flag to false on a chosen cell.

        }
    }

    @Override
    public void performAction() {
        System.out.println("performing performAction in Plant...");
        giveBirth();
    }

    public String getColor() {
        return this.color;
    }

}
