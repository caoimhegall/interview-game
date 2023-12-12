import { Component, OnInit } from '@angular/core';
import { GameService } from '../game/game.service';
import { CommonModule } from '@angular/common';
import { Player } from '../game/kalah-move.model';
import { KalahMove } from '../game/kalah-move.model';

@Component({
  selector: 'app-board',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './board.component.html',
  styleUrls: ['./board.component.css'],
})
export class BoardComponent implements OnInit {
  gameData: any;
  currentPlayer: Player = {
    name: 'Player1',  // Replace with actual player name
    playerNumber: 1   // Replace with actual player number
  };

  constructor(private gameService: GameService) {}

  ngOnInit(): void {
    this.initializeGame();
  }

  initializeGame(): void {
    this.gameData = {
      player1Pits: [4, 4, 4, 4, 4, 4],
      player2Pits: [4, 4, 4, 4, 4, 4],
      player1Store: 0,
      player2Store: 0,
      currentPlayer: 1,
    };
  }

  makeMove(pitIndex: number): void {
    const move: KalahMove = {
      player: this.currentPlayer,
      pitIndex
    };
    this.gameService.makeMove({ move }).subscribe(
      (response) => {
        // Handle the response or update the UI as needed
        console.log(response);
        // Optionally, you can fetch updated game state after making a move
        //this.fetchInitialGameState();
      },
      (error) => {
        console.error('Error making move:', error);
      }
    );
  }
}
