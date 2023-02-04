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
    public void move() {
        System.out.println("Herbivore moving...");
        List<Cell> neighbors = this.getCell().getNeighborCells();

        if(neighbors == null) return;

        List<Cell> edibleNeighbors = new ArrayList<>();
        List<Cell> emptyNeighbors = new ArrayList<>();

        // Distribute edible neighbors and empty neighbors
        for (Cell c:
                neighbors) {
            LifeForm lifeForm = c.getLifeForm();
            if(lifeForm == null) {
                emptyNeighbors.add(c);
            } else {
                if(lifeForm == null || lifeForm.getClass().equals(Plant.class))  {
                    edibleNeighbors.add(c);
                }
            }
        }

        int rand = 0;
        Cell curCell = this.getCell();
        Cell chosenCell;
        System.out.println(edibleNeighbors);
        if(edibleNeighbors.size() != 0) {
            chosenCell = super.chooseCell(edibleNeighbors);
        } else {
            chosenCell = super.chooseCell(emptyNeighbors);
        }
        this.setCell(chosenCell);
        this.setMoved(true);
        chosenCell.setLifeForm(this);
        curCell.setLifeForm(null);


        // eat if there is any life form to eat.
        // if empty, just move
//        eat();

        // if edibleneighbors is not empty, it gets higher precedence over empty neighbors
    }

    @Override
    public void performAction() {
        System.out.println("performing performAction in Herbivore...");
        // move first and then give birth
        move();
//        giveBirth();
    }

    public String getColor() {
        return color;
    }
}
