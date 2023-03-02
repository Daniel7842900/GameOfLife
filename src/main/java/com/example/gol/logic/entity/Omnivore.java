package com.example.gol.logic.entity;

import com.example.gol.logic.relationship.CarnEdible;
import com.example.gol.presentation.Cell;

import java.util.List;

public class Omnivore extends LifeForm implements CarnEdible {

    public Omnivore(Cell cell) {
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
    protected Omnivore createLife(Cell cell) {
        return new Omnivore(cell);
    }
}
