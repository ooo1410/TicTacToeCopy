package co.ppg2;




import co.ppg2.controllers.GameController;
import co.ppg2.controllers.PlayerDataController;
import co.ppg2.model.Player;
import co.ppg2.views.GameView;
import co.ppg2.views.PlayerPopup;
import javafx.application.Application;
import javafx.stage.Stage;




import java.util.ArrayList;




public class Main extends Application {
    private static ArrayList<Player> players;
    // TODO: create public static variables for the controllers, views, and players, etc and instantiate in main()
    public static GameController gameController;
    public static GameView gameView;

    public static void main(String[] args) {
        players = PlayerDataController.loadPlayers(); // Load players on start
        launch(args);
    }




    @Override
    public void start(Stage primaryStage) {
        // Prompt for Player X's username and Player O's username
        Player playerX = PlayerPopup.showPopup("Player X");
        Player playerO = PlayerPopup.showPopup("Player O");




        // Find or add Player X and Player O in the players list
        playerX = findOrAddPlayer(playerX.getUsername());
        playerO = findOrAddPlayer(playerO.getUsername());




        // Initialize GameController and GameView
        gameController = new GameController(playerX, playerO);
        gameView = new GameView(gameController, primaryStage);
        gameController.setGameView(gameView);




        // Launch the game view
        gameView.launchGame();
    }




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
