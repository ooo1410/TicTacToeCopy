package co.ppg2;

import co.ppg2.controllers.GameController;
import co.ppg2.controllers.PlayerDataController;
import co.ppg2.model.Player;
import co.ppg2.services.GameTimer;
import co.ppg2.views.GameView;
import co.ppg2.views.PlayerPopup;
import javafx.application.Application;
import javafx.stage.Stage;
import java.util.ArrayList;

/**
 * Adapted from <a href="https://liveexample.pearsoncmg.com/html/TicTacToe.html">...</a>
 * Main class for launching the Tic Tac Toe game application.
 * This class is responsible for setting up the game, including the players and game timer.
 * It also initializes the main game view and controls the flow of the game.
 */
public class Main extends Application {
    private static ArrayList<Player> players;
    public static GameController gameController;
    public static GameView gameView;
    public static GameTimer gameTimer; // Shared GameTimer instance

    /**
     * The entry point for the application. Loads saved players and launches the game.
     *
     * @param args the command-line arguments (unused).
     */
    public static void main(String[] args) {
        players = PlayerDataController.loadPlayers(); // Load players on start
        launch(args);
    }

    /**
     * Starts the application by displaying the player setup and initializing the game.
     * Prompts for the usernames of Player X and Player O, sets up the game,
     * and starts the game timer for Player X.
     *
     * @param primaryStage the main stage for the application.
     */
    @Override
    public void start(Stage primaryStage) {
        // Prompt for Player X's username and Player O's username
        Player playerX = PlayerPopup.showPopup("Player X");
        Player playerO = PlayerPopup.showPopup("Player O");

        // Find or add Player X and Player O in the players list
        playerX = findOrAddPlayer(playerX.getUsername());
        playerO = findOrAddPlayer(playerO.getUsername());

        // Initialize shared GameTimer
        gameTimer = new GameTimer();

        // Initialize GameController and GameView
        gameController = new GameController(playerX, playerO);
        gameController.setGameTimer(gameTimer); // Pass GameTimer to GameController
        gameView = new GameView(gameController, primaryStage);
        gameController.setGameView(gameView);

        // Launch the game view
        gameView.launchGame();

        // Start the timer for Player X
        gameTimer.startTimer(playerX.getUsername());
    }

    /**
     * Finds an existing player by username or creates a new player if not found.
     *
     * @param username the username of the player to find or add.
     * @return the found or newly created Player.
     */
    private Player findOrAddPlayer(String username) {
        for (Player player : players) {
            if (player.getUsername().equals(username)) {
                return player;
            }
        }
        Player newPlayer = new Player(username);
        players.add(newPlayer);
        PlayerDataController.savePlayers(players);
        return newPlayer;
    }
}
