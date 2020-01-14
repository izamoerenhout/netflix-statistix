package gui.logic.overviewControllers;

import appLogic.overviewModelObjects.SeriesTitle;
import database.DatabaseConnector;
import database.dao.overviewDAOs.SeriesTitleDAO;
import gui.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class Overview1Controller implements Initializable {
    public Stage stage;

    public ChoiceBox<SeriesTitle> seriesTitles;

    /** Returns to the Main Menu screen */
    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateComboBox();
    }

    public void populateComboBox() {
        SeriesTitleDAO seriesTitleDAO = new SeriesTitleDAO(new DatabaseConnector());
        seriesTitles.setItems(seriesTitleDAO.getAllSeriesTitles());
    }
}
