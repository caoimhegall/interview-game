package com.example.kalah.model;

import java.io.Serializable;

public class KalahBoardResponse implements Serializable {
    private KalahBoard kalahBoardState;

    public KalahBoardResponse(KalahBoard kalahBoardState) {
        this.kalahBoardState = kalahBoardState;
    }
}
