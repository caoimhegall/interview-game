package com.example.kalah.model;

public class KalahMove {

    //move includes a player object and selected pitIndex
    private Player player;
    private int pitIndex;

    public KalahMove(Player player, int pitIndex) {
        this.player = player;
        this.pitIndex = pitIndex;
    }

    public Player getPlayer() {
        return player;
    }

    public int getPitIndex() {
        return pitIndex;
    }
}
