import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { KalahMove } from './kalah-move.model';

@Injectable({
  providedIn: 'root',
})
export class GameService {
  private baseUrl = 'http://localhost:8080/api/game'; // Update with your Spring Boot backend URL

  constructor(private http: HttpClient) {}

  getGameState(): Observable<any> {
    return this.http.get(`${this.baseUrl}/state`);
  }

  makeMove(move: any): Observable<any> {
    return this.http.post(`${this.baseUrl}/move`, move);
  }
}