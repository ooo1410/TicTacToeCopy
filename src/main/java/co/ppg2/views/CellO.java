package co.ppg2.views;

import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

/**
 * Represents the graphical component of an "O" token in the TicTacToe game.
 */
public class CellO extends CellBase {

    /**
     * Constructs an "O" token with its graphical representation.
     */
    public CellO() {
        Ellipse ellipse = new Ellipse(50, 50, 40, 40);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        this.getChildren().add(ellipse);
    }

    @Override
    public void setToken(char token) {
        this.token = 'O';
    }
}