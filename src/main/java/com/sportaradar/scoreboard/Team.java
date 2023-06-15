package com.sportaradar.scoreboard;

import java.util.Objects;

/**
 * The Team class represents a sports team.
 * It stores information about the team's name and country.
 */
public class Team {

    private final String name;

    public Team(String name) {
        Objects.requireNonNull(name, "Name must not be null");
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Team team = (Team) o;
        return name.equals(team.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                '}';
    }
}
