package com.example.gol.logic.entity;

import com.example.gol.logic.relationship.CarnEdible;
import com.example.gol.logic.relationship.HerbEdible;
import com.example.gol.logic.relationship.OmniEdible;
import com.example.gol.presentation.Cell;

import java.util.List;

/**
 * Herbivore class.
 * Herbivore eats Plants.
 * Herbivore gives birth when there are at least 1 other Herbivore,
 * at least 2 other empty cells, and 2 other Plants.
 * Herbivore dies 5 turns if it doesn't eat.
 *
 * @Author Daniel Lim
 */
public class Herbivore extends LifeForm implements CarnEdible, OmniEdible {
    private String color = "YELLOW";
    private int numMates = 1;
    private int numEmpty = 2;
    private int numFood = 2;

    public Herbivore(Cell cell) {
//        super();
        super.cell = cell;
    }

    /**
     * Life forms move first and then give birth after.
     */
    @Override
    public void performAction() {
        System.out.println("performing performAction in Herbivore...");
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
            if(lifeForm instanceof HerbEdible) {
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
    protected Herbivore createLife(Cell cell) {
        return new Herbivore(cell);
    }

    public String getColor() {
        return color;
    }
}
