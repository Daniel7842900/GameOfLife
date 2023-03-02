package com.example.gol.logic.entity;

import com.example.gol.logic.relationship.CarnEdible;
import com.example.gol.logic.relationship.OmniEdible;
import com.example.gol.presentation.Cell;

import java.util.List;

/**
 * Carnivore class.
 * Carnivore eats Omnivores and Herbivores.
 * Carnivore gives birth when there are at least 1 other Carnivore,
 * at least 3 other empty cells, and 2 other Omnivores or Herbivores.
 * Carnivore dies 5 turns if it doesn't eat.
 *
 * @Author Daniel Lim
 */
public class Carnivore extends LifeForm implements OmniEdible {
    private String color = "RED";
    private int numMates = 1;
    private int numEmpty = 3;
    private int numFood = 2;

    public Carnivore(Cell cell) {
//        super();
        super.cell = cell;
    }

    /**
     * Life forms move first and then give birth after.
     */
    @Override
    public void performAction() {
        System.out.println("performing performAction in Carnivore...");
        move();
//        giveBirth(numMates, numEmpty, numFood);
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

        for (Cell c:
                neighbors) {
            LifeForm lifeForm = c.getLifeForm();
            if(lifeForm instanceof CarnEdible) {
                result++;
            }
        }

        return result;
    }

    /**
     * Create a new life form.
     *
     * @param cell
     * @return
     */
    @Override
    protected Carnivore createLife(Cell cell) {
        return new Carnivore(cell);
    }
}
