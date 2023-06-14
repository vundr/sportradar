package com.sportaradar.scoreboard;

public class Match {

    private final Score score;

    public Match() {
        this.score = new Score();
    }

    public Score getScore() {
        return score;
    }
}
