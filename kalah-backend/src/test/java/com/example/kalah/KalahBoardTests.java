package com.example.kalah;

import com.example.kalah.model.KalahBoard;
import com.example.kalah.model.KalahBoardResponse;
import com.example.kalah.model.KalahMove;
import com.example.kalah.model.Player;
import com.example.kalah.service.KalahGameService;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.Mockito.mock;

@SpringBootTest
class KalahBoardTests {
	KalahBoard testBoard = new KalahBoard(4, "player1", "player2");
	KalahBoardResponse mockResponse = new KalahBoardResponse(testBoard);
	KalahMove kalahMove = new KalahMove(new Player("player1", 1), 4);
	KalahGameService kalahGameService = mock(KalahGameService.class);

	@Test
	void testMakeMove() throws IllegalAccessException {
		Mockito.when(kalahGameService.makeMove(kalahMove)).thenReturn(mockResponse);
		KalahBoardResponse response = kalahGameService.makeMove(kalahMove);
		assert(response).equals(mockResponse);

	}

}
