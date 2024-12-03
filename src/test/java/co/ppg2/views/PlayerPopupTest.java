package co.ppg2.views;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerPopupTest extends ApplicationTest {

    private PlayerPopup popup;
    private Stage stage;

    @Override
    public void start(Stage stage) {
        // Initialize the PlayerPopup instance and set it to be displayed
        this.stage = stage;  // Save the stage for later checks
        popup = new PlayerPopup();
        Scene scene = new Scene(popup);
        stage.setScene(scene);
        stage.show();
    }

    @Test
    void testPlayerPopupInitialization() {
        // Check if the PlayerPopup is initialized
        assertNotNull(popup, "PlayerPopup instance should be successfully created");
    }

    @Test
    void testPopupVisibility() {
        // Test that the Stage containing the PlayerPopup is visible
        assertTrue(stage.isShowing(), "PlayerPopup stage should be visible");
    }}