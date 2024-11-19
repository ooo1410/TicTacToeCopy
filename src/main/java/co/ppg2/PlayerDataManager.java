package co.ppg2;




import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;




public class PlayerDataManager {




    private static final String FILE_NAME = "players.dat";




    public static void savePlayers(ArrayList<Player> players) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(players);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




    public static ArrayList<Player> loadPlayers() {
        ArrayList<Player> players = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            players = (ArrayList<Player>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return players;
    }




    public static void updatePlayerRecord(Player player) {
        ArrayList<Player> players = loadPlayers();
        Optional<Player> existingPlayer = players.stream()
                .filter(p -> p.getUsername().equalsIgnoreCase(player.getUsername()))
                .findFirst();




        if (existingPlayer.isPresent()) {
            Player storedPlayer = existingPlayer.get();
            storedPlayer.incrementWins();
            storedPlayer.incrementLosses();
        } else {
            players.add(player);
        }
        savePlayers(players);
    }




    public static ArrayList<Player> getTopPlayers() {
        ArrayList<Player> players = loadPlayers();
        players.sort(Comparator.comparingInt(Player::getWins).reversed());
        return new ArrayList<>(players.subList(0, Math.min(10, players.size())));
    }
}
