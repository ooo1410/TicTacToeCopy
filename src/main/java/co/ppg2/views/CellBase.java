package co.ppg2.views;

import javafx.scene.layout.Pane;

/**
 * An abstract base class representing a cell in a Tic-Tac-Toe game board.
 * This class provides the basic structure for managing a cell's token and rendering.
 */
public abstract class CellBase extends Pane {
    /**
     * The token assigned to this cell ('X', 'O', or ' ' for empty).
     */
    protected char token = ' ';

    /**
     * Retrieves the token currently assigned to this cell.
     *
     * @return the token character ('X', 'O', or ' ').
     */
    public char getToken() {
        return token;
    }

    /**
     * Abstract method to set the token for this cell.
     * Implementations should handle both data assignment and visual updates.
     *
     * @param token the character ('X' or 'O') to assign to this cell.
     */
    public abstract void setToken(char token);
}