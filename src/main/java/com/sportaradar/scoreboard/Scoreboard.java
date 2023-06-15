package com.sportaradar.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * The Scoreboard class represents a scoreboard that tracks matches and their scores.
 * It allows starting new matches, updating scores, and retrieving matches in progress.
 */
public class Scoreboard {

    private final Map<MatchId, Match> matches;

    public Scoreboard() {
        this.matches = new HashMap<>();
    }

    /**
     * Starts a new match between the home and away teams and adds it to the scoreboard.
     *
     * @param homeTeam The home team.
     * @param awayTeam The away team.
     * @return The unique identifier (MatchId) of the new match.
     */
    public MatchId startNewMatch(Team homeTeam, Team awayTeam) {
        var match = new Match(homeTeam, awayTeam);
        var id = new MatchId(UUID.randomUUID());
        matches.put(id, match);
        return id;
    }

    /**
     * Updates the score of a match identified by the matchId.
     *
     * @param matchId  The identifier of the match.
     * @param newScore The new score for the match.
     * @throws MatchNotFoundException If the match is not found by the given matchId.
     */
    public void updateScore(MatchId matchId, Score newScore) {
        var match = matches.get(matchId);
        if (match == null) {
            throw new MatchNotFoundException("Match not found by id: " + matchId);
        }
        match = match.updateScore(newScore);
        matches.put(matchId, match);
    }

    /**
     * Finishes a match and removes it from the scoreboard.
     *
     * @param matchId The identifier of the match.
     * @throws MatchNotFoundException If the match is not found by the given matchId.
     */
    public void finishMatch(MatchId matchId) {
        var match = matches.remove(matchId);
        if (match == null) {
            throw new MatchNotFoundException("Match not found by id: " + matchId);
        }
    }

    /**
     * Retrieves the matches in progress from the scoreboard.
     * The matches are sorted by score in descending order and then by the time of creation in descending order.
     *
     * @return A list of matches in progress, sorted by score and time of creation.
     */
    public List<Match> getMatchesInProgress() {
        var matchesInProgress = new ArrayList<>(matches.values());

        matchesInProgress.sort(
                Comparator.comparing((Match match) -> match.getScore().getTotalScore())
                        .reversed()
                        .thenComparing(Match::getStartTime, Comparator.reverseOrder())
        );
        return matchesInProgress;
    }
}
