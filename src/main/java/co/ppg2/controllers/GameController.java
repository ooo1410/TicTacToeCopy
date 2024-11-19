package co.ppg2.controllers;




import co.ppg2.services.GameTimer;
import co.ppg2.model.Player;
import co.ppg2.views.CellBase;
import co.ppg2.views.GameView;
import co.ppg2.views.LeaderboardPopup;

import java.util.ArrayList;




public class GameController {
    private char whoseTurn = 'X';
    private CellBase[][] cells = new CellBase[3][3];
    private Player playerX;
    private Player playerO;
    private GameTimer gameTimer;
    private GameView gameView;
    private ArrayList<Player> players;




    public GameController(Player playerX, Player playerO) {
        this.playerX = playerX;
        this.playerO = playerO;
        this.players = PlayerDataController.loadPlayers(); // Load existing players
    }




    public char getWhoseTurn() {
        return whoseTurn;
    }




    public Player getCurrentPlayer() {
        return (whoseTurn == 'X') ? playerX : playerO;
    }




    public void switchTurn() {
        whoseTurn = (whoseTurn == 'X') ? 'O' : 'X';
        if (gameTimer != null) {
            gameTimer.cancelTimer();
            gameTimer.startTimer();
        }
    }




    public boolean isFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j] == null || cells[i][j].getToken() == ' ') {
                    return false;
                }
            }
        }
        return true;
    }




    public boolean isWon(char token) {
        for (int i = 0; i < 3; i++) {
            if (cells[i][0].getToken() == token && cells[i][1].getToken() == token && cells[i][2].getToken() == token) {
                return true;
            }
        }
        for (int j = 0; j < 3; j++) {
            if (cells[0][j].getToken() == token && cells[1][j].getToken() == token && cells[2][j].getToken() == token) {
                return true;
            }
        }
        if (cells[0][0].getToken() == token && cells[1][1].getToken() == token && cells[2][2].getToken() == token) {
            return true;
        }
        if (cells[0][2].getToken() == token && cells[1][1].getToken() == token && cells[2][0].getToken() == token) {
            return true;
        }
        return false;
    }




    public void setCell(int row, int col, CellBase cell) {
        cells[row][col] = cell;
    }




    public void setGameTimer(GameTimer gameTimer) {
        this.gameTimer = gameTimer;
    }




    public CellBase getCell(int row, int col) {
        return cells[row][col];
    }




    public void setGameView(GameView gameView) {
        this.gameView = gameView;
    }




    public GameView getGameView() {
        return gameView;
    }




    public Player getWinner(char token) {
        return (token == 'X') ? playerX : playerO;
    }




    public void updateLeaderboard(char token) {
        Player winner = getWinner(token);
        Player loser = (token == 'X') ? playerO : playerX;




        for (Player player : players) {
            if (player.getUsername().equals(winner.getUsername())) {
                player.incrementWins();
            } else if (player.getUsername().equals(loser.getUsername())) {
                player.incrementLosses();
            }
        }




        PlayerDataController.savePlayers(players);
        LeaderboardPopup.showLeaderboard(players);
    }
}
