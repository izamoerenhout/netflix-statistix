package gui.logic;

import gui.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class MainMenuController {

    public Button buttonAccounts;
    public Button buttonProfiles;
    public Button buttonWatched;
    private Stage stage;

    public void showAccountsScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/AccountsScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    public void showProfilesScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/ProfilesScreen.fxml"));

        stage.setScene(new Scene(root));

    }

    public void showWatchedProgramsScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/WatchedProgramsScreen.fxml"));

        stage.setScene(new Scene(root));


    }

}
