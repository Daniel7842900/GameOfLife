package com.example.gol.logic.entity;

import com.example.gol.logic.relationship.CarnEdible;
import com.example.gol.logic.relationship.OmniEdible;
import com.example.gol.presentation.Cell;

import java.util.List;

/**
 * Omnivore class.
 * Omnivore eats Plants, Herbivores and Carnivores.
 * Omnivore gives birth when there are at least 1 other Omnivore,
 * at least 3 other empty cells, and 1 other Plants, Herbivores or Carnivores.
 * Omnivore dies 5 turns if it doesn't eat.
 *
 * @Author Daniel Lim
 */
public class Omnivore extends LifeForm implements CarnEdible {
    private String color = "BLUE";
    private int numMates = 1;
    private int numEmpty = 3;
    private int numFood = 1;
    public Omnivore(Cell cell) {
//        super();
        super.cell = cell;
    }

    /**
     * Life forms move first and then give birth after.
     */
    @Override
    public void performAction() {
        System.out.println("performing performAction in Omnivore...");
        move();
        giveBirth(numMates, numEmpty, numFood);
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
            if(lifeForm instanceof OmniEdible) {
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
    protected Omnivore createLife(Cell cell) {
        return new Omnivore(cell);
    }
}
