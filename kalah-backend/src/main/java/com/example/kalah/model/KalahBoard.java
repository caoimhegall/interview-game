package com.example.kalah.model;

public class KalahBoard {
    private Pit[] pits;
    private Store[] stores;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public KalahBoard(int initialStonesPerPit, String player1Name, String player2Name) {
        player1 = new Player(player1Name, 1);
        player2 = new Player(player2Name, 2);
        currentPlayer = player1;
        //initialize the board with stones in each pit
        //player 1's pits: 0-5, player 2's pits: 7-12
        pits = new Pit[14];
        //player 1's store: 6, player 2's store: 13
        stores = new Store[]{new Store(player1), new Store(player2)};

        for (int i = 0; i < pits.length; i++) {
            if (i != 6 && i!= 13) {
                pits[i] = new Pit(initialStonesPerPit, (i < 6) ? player1 : player2);
            }
        }
    }

    public Pit[] getPits() {
        return pits.clone();
    }

    public Store[] getStores() {
        return stores.clone();
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void makeMove(KalahMove move) throws IllegalAccessException {
        int pitIndex = move.getPitIndex();
        if(!validMove(move)) {
            throw new IllegalAccessException("Move not valid for your turn");
        }
        Pit selected = pits[pitIndex];
        int numberMoves = selected.getSeeds();
        
        //clear selected pit
        selected.clear();

        //sow seeds in the selected pit
        int curr = pitIndex + 1;
        while (numberMoves > 0) {
            if(curr != 6 && curr != 13) {
                pits[curr].sow(1);
                numberMoves -= 1;
            }
            curr = (curr + 1) % pits.length;
        }
        int lastStoneIndex = (curr - 1 + pits.length) % pits.length;
        if (isLastStone(lastStoneIndex)) {
            captureStones(lastStoneIndex);
        }

        //update current player after turn
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
    private boolean isLastStone(int pitIndex) {
        return (pits[pitIndex].getSeeds() == 1) && (pits[pitIndex].getOwner().equals(currentPlayer));
    }

    private void captureStones(int lastStoneIndex) {
        int oppositePitIndex = pits.length - 2 - lastStoneIndex;
        int capturedStones = pits[lastStoneIndex].getSeeds() + pits[oppositePitIndex].getSeeds();

        //capture the seeds by adding them to the current player's store
        stores[currentPlayer.getPlayerNumber() - 1].sow(capturedStones);

        //clear the seeds from the captured pits
        pits[lastStoneIndex].clear();
        pits[oppositePitIndex].clear();
    }

    private boolean validMove(KalahMove move) {
        Pit selected = pits[move.getPitIndex()];
        return (selected.getOwner().equals(currentPlayer)) && (selected.getSeeds() > 0);
    }
}
