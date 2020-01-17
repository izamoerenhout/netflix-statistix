package gui.logic;

import gui.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

/** Controller for the main menu screen */
public class MainMenuController {
    private Stage stage;

    /** Shows the Accounts screen. */
    public void showAccountsScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/AccountsScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows the Profiles screen. */
    public void showProfilesScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/ProfilesScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows the Watched Programs screen. */
    public void showWatchedProgramsScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/WatchedProgramsScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Shows the Overview Selection screen. */
    public void showOverviewSelectionScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/OverviewSelectionScreen.fxml"));

        stage.setScene(new Scene(root));
    }
}
