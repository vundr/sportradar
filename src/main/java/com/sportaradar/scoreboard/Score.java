package com.sportaradar.scoreboard;

import java.util.Objects;

/**
 * The Score class represents the score of a match.
 * It stores the home score, away score, and provides methods to calculate the total score.
 */
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

    /**
     * Returns the total score (sum of home and away scores).
     *
     * @return The total score.
     */
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
