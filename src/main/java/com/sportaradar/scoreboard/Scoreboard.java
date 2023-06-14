package com.sportaradar.scoreboard;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
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

    public Collection<Match> getAllMatches() {
        return Collections.unmodifiableCollection(matches.values());
    }
}
