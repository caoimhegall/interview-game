package com.example.kalah.model;

public class Store extends Pit{
    private Player player;
    public Store(Player player) {
        super(0, player);
        this.player = player;
    }
    public Player getPlayer() {
        return player;
    }
}
