package com.example.gol.logic.entity;

public abstract class LifeForm {
    private int turnToDeath = 5;

    public void eat() {

    }

    public void giveBirth() {

    }

    public void die() {

    }

    public void move() {

    }

    public int getTurnToDeath() {
        return this.turnToDeath;
    }

    public void setTurnToDeath(int turn) {
        this.turnToDeath = turn;
    }

}
