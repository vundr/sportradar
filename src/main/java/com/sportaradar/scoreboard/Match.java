package com.sportaradar.scoreboard;

import java.time.LocalDateTime;
import java.util.Objects;

/**
 * The Match class represents a single match between two teams.
 * It stores information about the home team, away team, score, and start time of the match.
 */
public class Match {

    private final Team homeTeam;

    private final Team awayTeam;

    private final Score score;

    private final LocalDateTime startTime;

    public Match(Team homeTeam, Team awayTeam) {
        this(homeTeam, awayTeam, new Score(), LocalDateTime.now());
    }

    Match(Team homeTeam, Team awayTeam, Score score, LocalDateTime startTime) {
        Objects.requireNonNull(homeTeam, "Home team must not be null");
        Objects.requireNonNull(awayTeam, "Away team must not be null");
        Objects.requireNonNull(score, "Score must not be null");
        Objects.requireNonNull(score, "Start time must not be null");

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.startTime = startTime;
    }

    /**
     * Updates the score of the match and returns a new Match instance with the updated score.
     *
     * @param score The new score for the match.
     * @return A new Match instance with the updated score.
     */
    public Match updateScore(Score score) {
        return new Match(homeTeam, awayTeam, score, startTime);
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public Score getScore() {
        return score;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return homeTeam.equals(match.homeTeam) && awayTeam.equals(match.awayTeam) && score.equals(match.score);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeam, awayTeam, score);
    }

    @Override
    public String toString() {
        return "Match{" +
                "homeTeam=" + homeTeam +
                ", awayTeam=" + awayTeam +
                ", score=" + score +
                '}';
    }
}
