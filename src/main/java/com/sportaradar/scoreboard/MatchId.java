package com.sportaradar.scoreboard;

import java.util.Objects;
import java.util.UUID;

public class MatchId {

    private final String id;

    MatchId(UUID id) {
        Objects.requireNonNull(id, "UUID must not be null");
        this.id = id.toString();
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MatchId matchId = (MatchId) o;
        return id.equals(matchId.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MatchId{" +
                "id='" + id + '\'' +
                '}';
    }
}
