package gui;

import appLogic.Account;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ProfilesScreenController {


    public Stage stage;


    public Button buttonCreateProfile;
    public Button buttonEditProfile;
    public Button buttonDeleteProfile;
    public Button buttonBack;

    private ObservableList<Account> list;

    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }
}
