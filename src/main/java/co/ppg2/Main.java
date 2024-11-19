package co.ppg2;




import javafx.application.Application;
import javafx.stage.Stage;




import java.util.ArrayList;




public class Main extends Application {
    private static ArrayList<Player> players;




    public static void main(String[] args) {
        players = PlayerDataManager.loadPlayers(); // Load players on start
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
        GameController gameController = new GameController(playerX, playerO);
        GameView gameView = new GameView(gameController, primaryStage);
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
        PlayerDataManager.savePlayers(players);
        return newPlayer;
    }
}
