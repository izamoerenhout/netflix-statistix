package gui.logic.overviewControllers;

import appLogic.overviewModelObjects.Overview1;
import database.DatabaseConnector;
import database.dao.overviewDAOs.Overview1DAO;
import gui.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/** Controller for Overview 1. */
public class Overview1Controller implements Initializable {
    public Stage stage;
    public Button buttonBack;
    public ComboBox<String> comboBox;

    public TableView<Overview1> tableOverview1;
    public TableColumn<Overview1, Integer> col_progId;
    public TableColumn<Overview1, String> col_epNr;
    public TableColumn<Overview1, String> col_epName;
    public TableColumn<Overview1, Integer> col_avgPctWatched;

    /** Returns to the Overview Selection screen */
    public void returnToOverviewSelectionScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/OverviewSelectionScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Every time this scene is shown, populateComboBox will be called and populates the ComboBox with series titles. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateComboBox();
    }

    /** Calls getAllSeriesTitles from Overview1DAO and populates the ComboBox with all series titles from the database. */
    public void populateComboBox() {
        Overview1DAO overview1DAO = new Overview1DAO(new DatabaseConnector());
        comboBox.setItems(overview1DAO.getAllSeriesTitles());
    }

    /** Gets called once a selection is made from the ComboBox. Populates TableView with information based on selected series. */
    public void populateTableView() {
        Overview1DAO overview1DAO = new Overview1DAO(new DatabaseConnector());

        try {
            // Set attributes to TableView columns.
            col_progId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_epNr.setCellValueFactory(new PropertyValueFactory<>("episodeNr"));
            col_epName.setCellValueFactory(new PropertyValueFactory<>("episodeName"));
            col_avgPctWatched.setCellValueFactory(new PropertyValueFactory<>("avgPctWatched"));

            // Set data to TableView.
            tableOverview1.setItems(overview1DAO.getAllRecords(comboBox.getSelectionModel().getSelectedItem()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
