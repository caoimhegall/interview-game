package com.example.kalah.service;
import com.example.kalah.model.KalahBoard;
import com.example.kalah.model.KalahBoardResponse;
import com.example.kalah.model.KalahMove;
import org.springframework.stereotype.Service;

@Service
public class KalahGameService {
    private KalahBoard kalahBoard;

    public KalahGameService() {
        kalahBoard = new KalahBoard(4, "Player1", "Player2");
    }

    //not used in my game yet but starts the game
    public void startGame() {
        kalahBoard = new KalahBoard(4, "Player1", "Player2");
    }

    //make move, returns KalahBoardResponse object to update frontend
    public KalahBoardResponse makeMove(KalahMove move) throws IllegalAccessException {
        kalahBoard.makeMove(move);

        if (isGameOver()) {
            System.out.println("Game over!");
        }
        return new KalahBoardResponse(kalahBoard);
    }

    public boolean isGameOver() {
        return kalahBoard.getPits()[0].getSeeds() == 0 || kalahBoard.getPits()[7].getSeeds() == 0;
    }

}
