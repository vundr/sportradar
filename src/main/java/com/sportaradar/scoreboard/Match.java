package com.sportaradar.scoreboard;

import java.util.Objects;

public class Match {

    private final Team homeTeam;

    private final Team awayTeam;

    private final Score score;

    public Match(Team homeTeam, Team awayTeam) {
        Objects.requireNonNull(homeTeam, "Home team must not be null");
        Objects.requireNonNull(awayTeam, "Away team must not be null");

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = new Score();
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
