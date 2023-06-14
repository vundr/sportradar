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
}
