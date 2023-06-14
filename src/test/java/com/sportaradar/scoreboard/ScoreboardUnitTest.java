package com.sportaradar.scoreboard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreboardUnitTest {

    @Test
    void whenNewMatchStarted_itShouldAppearOnTheBoard() {
        //Arrange
        var scoreboard = new Scoreboard();
        //Act
        scoreboard.startNewMatch("Home", "Away");

        //Assert
        assertEquals(1, scoreboard.getAllMatches().size());
    }

    @Test
    void whenNewMatchStarted_initialScoreShouldBeZero() {
        //Arrange
        var scoreboard = new Scoreboard();
        //Act
        scoreboard.startNewMatch("Home", "Away");

        //Assert
        var resultScore = scoreboard.getAllMatches().iterator().next().getScore();
        assertEquals(0, resultScore.getAwayScore());
        assertEquals(0, resultScore.getHomeScore());
    }
}
