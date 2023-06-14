package com.sportaradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ScoreboardUnitTest {

    @Test
    void whenNewMatchStarted_itShouldAppearOnTheBoard() {
        //Arrange
        var scoreboard = new Scoreboard();
        var homeTeam = new Team("Home");
        var awayTeam = new Team("Away");
        //Act
        scoreboard.startNewMatch(homeTeam, awayTeam);

        //Assert
        assertEquals(1, scoreboard.getAllMatches().size());
    }

    @Test
    void whenNewMatchStarted_initialScoreShouldBeZero() {
        //Arrange
        var scoreboard = new Scoreboard();
        var homeTeam = new Team("Home");
        var awayTeam = new Team("Away");
        //Act
        scoreboard.startNewMatch(homeTeam, awayTeam);

        //Assert
        var resultScore = scoreboard.getAllMatches().iterator().next().getScore();
        assertEquals(0, resultScore.getAwayScore());
        assertEquals(0, resultScore.getHomeScore());
    }

    @Test
    void whenScoreUpdated_scoreOfTheMatchShouldBeUpdated() {
        //Arrange
        var scoreboard = new Scoreboard();
        var homeTeam = new Team("Home");
        var awayTeam = new Team("Away");
        var newScore = new Score(1, 0);

        //Act
        var matchId = scoreboard.startNewMatch(homeTeam, awayTeam);
        scoreboard.updateScore(matchId, newScore);

        //Assert
        var resultScore = scoreboard.getAllMatches().iterator().next().getScore();
        assertEquals(newScore, resultScore);
    }

    @Test
    void whenScoreUpdatedAndMatchNotFound_shouldThrowException() {
        //Arrange
        var scoreboard = new Scoreboard();
        var homeTeam = new Team("Home");
        var awayTeam = new Team("Away");
        var newScore = new Score(1, 0);
        var matchId = new MatchId("NOT_FOUND");

        //Act + Assert
        scoreboard.startNewMatch(homeTeam, awayTeam);
        assertThrows(MatchNotFoundException.class, () -> scoreboard.updateScore(matchId, newScore));
    }

    @Test
    void whenMatchFinished_itShouldBeRemovedFromTheBoard() {
        //Arrange
        var scoreboard = new Scoreboard();
        var homeTeam = new Team("Home");
        var awayTeam = new Team("Away");

        //Act
        var matchId = scoreboard.startNewMatch(homeTeam, awayTeam);
        scoreboard.finishMatch(matchId);

        //Assert
        assertEquals(0, scoreboard.getAllMatches().size());
    }
}
