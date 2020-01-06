package gui;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AccountsScreenController {

    public Button buttonCreateAccount;
    public Button buttonEditAccount;
    public Button buttonDeleteAccount;
    public Button buttonBackAccount;
    public Stage stage;

    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }
}
