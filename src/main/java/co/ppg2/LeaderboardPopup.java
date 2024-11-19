package co.ppg2;




import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;




import java.util.List;
import java.util.stream.Collectors;




public class LeaderboardPopup {




    public static void showLeaderboard(List<Player> players) {
        Stage popupStage = new Stage();
        VBox vbox = new VBox();
        Label label = new Label("Leaderboard:");




        ListView<String> listView = new ListView<>();




        players.stream()
                .sorted((p1, p2) -> Integer.compare(p2.getWins(), p1.getWins()))
                .limit(10)
                .forEach(player -> listView.getItems().add(player.toString()));




        vbox.getChildren().addAll(label, listView);
        Scene scene = new Scene(vbox, 300, 300);
        popupStage.setTitle("Leaderboard");
        popupStage.setScene(scene);
        popupStage.showAndWait();
    }
}
