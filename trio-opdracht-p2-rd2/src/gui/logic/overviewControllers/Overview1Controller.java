package gui.logic.overviewControllers;

import appLogic.overviewModelObjects.Overview1;
import appLogic.overviewModelObjects.SeriesTitle;
import database.DatabaseConnector;
import database.dao.overviewDAOs.Overview1DAO;
import gui.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Overview1Controller implements Initializable {
    public Stage stage;

    public ComboBox<String> comboBox;

    /** Returns to the Main Menu screen */
    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Overview1DAO overview1DAO = new Overview1DAO(new DatabaseConnector());
        comboBox.setItems(overview1DAO.getAllSeriesTitles());
    }
}
