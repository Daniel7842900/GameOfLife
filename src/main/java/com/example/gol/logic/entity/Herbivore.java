package com.example.gol.logic.entity;

import com.example.gol.presentation.Cell;

public class Herbivore extends LifeForm {

    private String color = "YELLOW";

    private Cell cell;

    public Herbivore(Cell cell) {
        this.cell = cell;
    }

    @Override
    public void performAction() {

    }

    public String getColor() {
        return color;
    }
}
