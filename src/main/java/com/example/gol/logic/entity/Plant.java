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

    /**
     * Count the edible cells among neighbor cells.
     *
     * @param neighbors
     * @return
     */
    @Override
    protected int countEdible(List<Cell> neighbors) {
        int result = 0;
        return result;
    }

    /**
     * Create a new life form.
     *
     * @param cell
     * @return
     */
    @Override
    protected Plant createLife(Cell cell) {
        return new Plant(cell);
    }

    /**
     * Plants give birth (seed).
     */
    @Override
    public void performAction() {
        System.out.println("performing performAction in Plant...");
        giveBirth(numMates, numEmpty, numFood);
    }

    public String getColor() {
        return this.color;
    }

}
