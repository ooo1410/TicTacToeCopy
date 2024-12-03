package co.ppg2.model;

import java.io.Serializable;

/**
 * Represents a player in the game, tracking their username, win count, and loss count.
 * Implements {@link Serializable} to allow instances to be saved and loaded.
 */
public class Player implements Serializable {

    /**
     * The username of the player.
     */
    private final String username;

    /**
     * The number of games the player has won.
     */
    private int wins;

    /**
     * The number of games the player has lost.
     */
    private int losses;

    /**
     * Creates a new {@link Player} instance with a specified username.
     * The player's win and loss counts are initialized to zero.
     *
     * @param username the username of the player
     */
    public Player(String username) {
        this.username = username;
        this.wins = 0;
        this.losses = 0;
    }

    /**
     * Gets the username of the player.
     *
     * @return the username of the player
     */
    public String getUsername() {
        return username;
    }

    /**
     * Gets the number of games the player has won.
     *
     * @return the number of wins
     */
    public int getWins() {
        return wins;
    }

    /**
     * Gets the number of games the player has lost.
     *
     * @return the number of losses
     */
    public int getLosses() {
        return losses;
    }

    /**
     * Increments the player's win count by one.
     */
    public void incrementWins() {
        this.wins++;
    }

    /**
     * Increments the player's loss count by one.
     */
    public void incrementLosses() {
        this.losses++;
    }

    /**
     * Returns a string representation of the player, including their username,
     * number of wins, and number of losses.
     *
     * @return a string representation of the player
     */
    @Override
    public String toString() {
        return username + " - Wins: " + wins + ", Losses: " + losses;
    }
}