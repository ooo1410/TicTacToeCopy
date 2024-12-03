package co.ppg2.views;

import javafx.scene.control.Label;

/**
 * A custom label with predefined styling for use in the game's user interface.
 */
public class LabelBase extends Label {
    /**
     * Constructs a LabelBase with the specified text and applies default styling.
     *
     * @param text the text to display on the label.
     */
    public LabelBase(String text) {
        super(text);
        setStyle("-fx-font-size: 16px; -fx-background-color: lightblue;");
    }
}