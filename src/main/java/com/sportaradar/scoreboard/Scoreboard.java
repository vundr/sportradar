package com.sportaradar.scoreboard;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Scoreboard {

    private final Map<String, Match> matches;

    public Scoreboard() {
        this.matches = new HashMap<>();
    }

    public void startNewMatch(String homeTeam, String awayTeam) {

    }

    public Collection<Match> getAllMatches() {
        return Collections.unmodifiableCollection(matches.values());
    }
}