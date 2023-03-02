package com.example.gol.logic.entity;

import com.example.gol.logic.relationship.HerbEdible;
import com.example.gol.logic.relationship.OmniEdible;
import com.example.gol.presentation.Cell;

import java.util.List;

/**
 * Plant class.
 * Plants don't eat.
 * Plant gives birth when there are at least 2 other Plants,
 * at least 3 other empty cells.
 * Plant doesn't die unless gets eaten.
 *
 * @Author Daniel Lim
 */
public class Plant extends LifeForm implements HerbEdible, OmniEdible {
    String color = "GREEN";
    private int numMates = 2;
    private int numEmpty = 3;
    private int numFood = 0;

    public Plant(Cell cell) {
        super.cell = cell;
    }

    @Override
    protected int countEdible(List<Cell> neighbrs) {
        int result = 0;
        return result;
    }

    @Override
    protected Plant createLife(Cell cell) {
        return new Plant(cell);
    }

//    @Override
//    public void giveBirth(int numMates, int numEmpty, int numFood) {
//        System.out.println("Giving birth Plant...");
//        List<Cell> neighbors = this.getCell().getNeighborCells();
//        List<Cell> availableNeighbors = new ArrayList<>();
//
//        System.out.println(super.getCell().getRow() + " " + super.getCell().getCol());
//
//        int countPlant = 0;
//        int countEmpty = 0;
//
//        for (Cell c:
//                neighbors) {
//            System.out.println(" row: " + c.getRow() + "col: " + c.getCol());
//            LifeForm lifeForm = c.getLifeForm();
//            if(!lifeForm.isMoved()) {
//                if(lifeForm == null)  {
//                    countEmpty++;
//                    availableNeighbors.add(c);
//                } else if(lifeForm.getClass().equals(Plant.class)) {
//                    countPlant++;
//                }
//            }
//        }
//
//        System.out.println("countPlant: " + countPlant);
//        System.out.println("countEmpty: " + countEmpty);
//
//        if(countPlant >= 2 && countEmpty >= 3) {
//            System.out.println("Plant seeding...");
//            Cell chosenCell = super.chooseCell(availableNeighbors);
//            System.out.println(chosenCell.getRow() + " " + chosenCell.getCol());
//            chosenCell.setLifeForm(new Plant(chosenCell));
//            chosenCell.getLifeForm().setMoved(true);
//
//            // Set moved flag to false on a chosen cell.
//
//        }
//    }

    @Override
    public void performAction() {
        System.out.println("performing performAction in Plant...");
//        giveBirth(numMates, numEmpty, numFood);
    }

    public String getColor() {
        return this.color;
    }

}
