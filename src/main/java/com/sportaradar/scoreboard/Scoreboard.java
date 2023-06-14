package com.sportaradar.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class Scoreboard {

    private final Map<MatchId, Match> matches;

    public Scoreboard() {
        this.matches = new HashMap<>();
    }

    public MatchId startNewMatch(Team homeTeam, Team awayTeam) {
        var match = new Match(homeTeam, awayTeam);
        var id = new MatchId(UUID.randomUUID());
        matches.put(id, match);
        return id;
    }

    public void updateScore(MatchId matchId, Score newScore) {
        var match = matches.get(matchId);
        if (match == null) {
            throw new MatchNotFoundException("Match not found by id: " + matchId);
        }
        match = match.updateScore(newScore);
        matches.put(matchId, match);
    }

    public void finishMatch(MatchId matchId) {
        var match = matches.remove(matchId);
        if (match == null) {
            throw new MatchNotFoundException("Match not found by id: " + matchId);
        }
    }

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
