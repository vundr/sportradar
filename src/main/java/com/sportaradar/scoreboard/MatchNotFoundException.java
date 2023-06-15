package com.sportaradar.scoreboard;

/**
 * The MatchNotFoundException class represents an exception that is thrown when a match is not found.
 */
public class MatchNotFoundException extends RuntimeException {

    public MatchNotFoundException(String message) {
        super(message);
    }
}
