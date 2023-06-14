package com.sportaradar.scoreboard;

import java.util.Objects;

public class Score {

    private final int homeScore;
    private final int awayScore;

    public Score() {
        this(0, 0);
    }

    public Score(int homeScore, int awayScore) {
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    public int getHomeScore() {
        return homeScore;
    }

    public int getAwayScore() {
        return awayScore;
    }

    public int getTotalScore() {
        return homeScore + awayScore;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Score score = (Score) o;
        return homeScore == score.homeScore && awayScore == score.awayScore;
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeScore, awayScore);
    }

    @Override
    public String toString() {
        return "Score{" +
                "homeScore=" + homeScore +
                ", awayScore=" + awayScore +
                '}';
    }
}
