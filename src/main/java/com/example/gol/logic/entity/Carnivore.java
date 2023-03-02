package com.example.gol.logic.entity;

import com.example.gol.logic.relationship.OmniEdible;
import com.example.gol.presentation.Cell;

import java.util.List;

public class Carnivore extends LifeForm implements OmniEdible {

    public Carnivore(Cell cell) {
//        super();
        super.cell = cell;
    }

    @Override
    public void performAction() {

    }

    @Override
    protected int countEdible(List<Cell> neighbrs) {
        int result = 0;
        return result;
    }

    @Override
    protected Carnivore createLife(Cell cell) {
        return new Carnivore(cell);
    }
}
