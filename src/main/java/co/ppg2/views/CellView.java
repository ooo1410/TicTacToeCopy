package co.ppg2.views;

import co.ppg2.controllers.GameController;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

/**
 * Represents the visual component of a single cell in the Tic-Tac-Toe game board.
 * It is responsible for rendering the cell and handling user interactions.
 */
public class CellView extends StackPane {
    /**
     * The button displayed in this cell.
     */
    private final Button button;

    /**
     * The row index of this cell in the game board.
     */
    private final int row;

    /**
     * The column index of this cell in the game board.
     */
    private final int col;

    /**
     * The game controller managing the game logic.
     */
    private final GameController gameController;

    /**
     * Constructs a CellView with specified row, column, and game controller.
     *
     * @param row            the row index of the cell.
     * @param col            the column index of the cell.
     * @param gameController the game controller to manage game logic and state.
     */
    public CellView(int row, int col, GameController gameController) {
        this.row = row;
        this.col = col;
        this.gameController = gameController;

        // Initialize the button and add it to the cell view
        button = new Button();
        button.setPrefSize(100, 100);
        getChildren().add(button);

        // Set action for button click
        button.setOnAction(e -> handleClick());
    }

    /**
     * Handles the user click on the cell.
     * Updates the game state and visual display, checks for win or tie conditions,
     * and switches turns if applicable.
     */
    private void handleClick() {
        // Only proceed if the cell is empty
        if (gameController.getCell(row, col) == null || gameController.getCell(row, col).getToken() == ' ') {
            char currentPlayerToken = gameController.getWhoseTurn();

            // Set the token in GameController and update button text
            gameController.setCell(row, col, new CellBase() {
                @Override
                public void setToken(char token) {
                    this.token = currentPlayerToken;
                    button.setText(String.valueOf(currentPlayerToken));
                }
            });

            // Check if there's a winner or if the board is full
            if (gameController.isWon(currentPlayerToken)) {
                gameController.getGameView().handleGameOver(currentPlayerToken);  // Handle win
            } else if (gameController.isFull()) {
                gameController.getGameView().handleTie();  // Handle tie
            } else {
                // Switch player turn and prepare for the next move
                gameController.switchTurn();
            }
        }
    }
}