package com.example.kalah.controller;

import com.example.kalah.model.KalahBoard;
import com.example.kalah.model.KalahBoardResponse;
import com.example.kalah.model.KalahMove;
import com.example.kalah.service.KalahGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/game")

public class GameController {
    private final KalahGameService gameService;

    @Autowired
    public GameController(KalahGameService gameService) {
        this.gameService = gameService;
    }
    @PostMapping("/start")
    public ResponseEntity<String> startGame() {
        gameService.startGame();
        return ResponseEntity.ok("Game started!");
    }
    @PostMapping(value = "/move", consumes = "application/json")
    public KalahBoardResponse makeMove(@RequestBody KalahMove move) throws IllegalAccessException {
        return gameService.makeMove(move);
    }
    @GetMapping("/gameOver")
    public ResponseEntity<Boolean> isGameOver() {
        return ResponseEntity.ok(gameService.isGameOver());
    }
}
