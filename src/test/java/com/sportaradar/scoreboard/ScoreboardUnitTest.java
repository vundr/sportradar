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
        assertEquals(1, scoreboard.getMatchesInProgress().size());
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
        var resultScore = scoreboard.getMatchesInProgress().iterator().next().getScore();
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
        var resultScore = scoreboard.getMatchesInProgress().iterator().next().getScore();
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
        assertEquals(0, scoreboard.getMatchesInProgress().size());
    }

    @Test
    void whenMatchFinishedAndMatchNotFound_shouldThrowException() {
        //Arrange
        var scoreboard = new Scoreboard();
        var homeTeam = new Team("Home");
        var awayTeam = new Team("Away");
        var matchId = new MatchId("NOT_FOUND");

        //Act + Assert
        scoreboard.startNewMatch(homeTeam, awayTeam);
        assertThrows(MatchNotFoundException.class, () -> scoreboard.finishMatch(matchId));
    }

    @Test
    void whenGettingMatches_theyShouldBeSortedByScore() {
        //Arrange
        var scoreboard = new Scoreboard();
        var firstHomeTeam = new Team("First Home");
        var firstAwayTeam = new Team("First Away");
        var firstScore = new Score(1, 0);
        var secondHomeTeam = new Team("Second Home");
        var secondAwayTeam = new Team("Second Away");
        var secondScore = new Score(1, 1);
        var thirdHomeTeam = new Team("Third Home");
        var thirdAwayTeam = new Team("Third Away");
        var thirdScore = new Score(2, 2);

        //Act
        var firstMatchId = scoreboard.startNewMatch(firstHomeTeam, firstAwayTeam);
        scoreboard.updateScore(firstMatchId, firstScore);

        var secondMatchId = scoreboard.startNewMatch(secondHomeTeam, secondAwayTeam);
        scoreboard.updateScore(secondMatchId, secondScore);

        var thirdMatchId = scoreboard.startNewMatch(thirdHomeTeam, thirdAwayTeam);
        scoreboard.updateScore(thirdMatchId, thirdScore);

        //Assert
        var result = scoreboard.getMatchesInProgress();
        assertEquals(thirdScore, result.get(0).getScore());
        assertEquals(secondScore, result.get(1).getScore());
        assertEquals(firstScore, result.get(2).getScore());
    }

    @Test
    void whenGettingMatches_theyShouldBeSortedByScoreAndTimeOfCreation() {
        //Arrange
        var scoreboard = new Scoreboard();
        var firstHomeTeam = new Team("First Home");
        var firstAwayTeam = new Team("First Away");
        var score = new Score(1, 0);
        var secondHomeTeam = new Team("Second Home");
        var secondAwayTeam = new Team("Second Away");
        var thirdHomeTeam = new Team("Third Home");
        var thirdAwayTeam = new Team("Third Away");

        //Act
        var firstMatchId = scoreboard.startNewMatch(firstHomeTeam, firstAwayTeam);
        scoreboard.updateScore(firstMatchId, score);

        var secondMatchId = scoreboard.startNewMatch(secondHomeTeam, secondAwayTeam);
        scoreboard.updateScore(secondMatchId, score);

        var thirdMatchId = scoreboard.startNewMatch(thirdHomeTeam, thirdAwayTeam);
        scoreboard.updateScore(thirdMatchId, score);

        //Assert
        var result = scoreboard.getMatchesInProgress();
        assertEquals(thirdHomeTeam, result.get(0).getHomeTeam());
        assertEquals(secondHomeTeam, result.get(1).getHomeTeam());
        assertEquals(firstHomeTeam, result.get(2).getHomeTeam());
    }
}
