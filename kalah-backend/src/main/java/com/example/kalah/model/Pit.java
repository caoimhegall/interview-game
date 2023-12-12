package com.example.kalah.model;

public class Pit {
    private Player owner;
    private int seeds;
    public Pit(int initialStones, Player owner) {
        this.seeds = initialStones;
        this.owner = owner;
    }
    public int getSeeds() {
        return seeds;
    }
    public Player getOwner() {
        return owner;
    }
    public void sow(int amount) {
        seeds += amount;
    }
    public void clear() {
        seeds = 0;
    }
}
