package gui.logic.overviewControllers;

import domain.overviewDomain.Overview2;
import database.DatabaseConnector;
import database.dao.overviewDAOs.Overview2DAO;
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

public class Overview2Controller implements Initializable {
    public Stage stage;
    public Button buttonBack;

    public ComboBox<String> comboBoxSeries;
    public ComboBox<String> comboBoxAccounts;

    public TableView<Overview2> tableOverview2;
    public TableColumn<Overview2, String> col_email;
    public TableColumn<Overview2, Integer> col_progId;
    public TableColumn<Overview2, String> col_epNr;
    public TableColumn<Overview2, String> col_epName;
    public TableColumn<Overview2, Integer> col_avgPctWatched;

    /** Returns to the Overview Selection screen. */
    public void returnToOverviewSelectionScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/OverviewSelectionScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Every time this scene is shown, populateComboBoxSeries will be called and populates the ComboBox with series titles. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateComboBoxSeries();
    }

    /** Calls getAllSeriesTitles from Overview2DAO and populates the ComboBox with all series titles from the database. */
    public void populateComboBoxSeries() {
        Overview2DAO overview2DAO = new Overview2DAO(new DatabaseConnector());
        comboBoxSeries.setItems(overview2DAO.getAllSeriesTitles());
    }

    /** Calls getAllAccountEmails from Overview2DAO and populates the ComboBox with all account emails from the database.
     * This method gets called once a series is selected from comboBoxSeries. */
    public void populateComboBoxAccounts() {
        Overview2DAO overview2DAO = new Overview2DAO(new DatabaseConnector());
        comboBoxAccounts.setItems(overview2DAO.getAllAccountEmails());
    }

    /** Gets called once a selection is made from comboBoxAccounts. Populates TableView with information based on selected series and account. */
    public void populateTableView() {
        Overview2DAO overview2DAO = new Overview2DAO(new DatabaseConnector());

        try {
            // Set attributes to TableView columns.
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_progId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_epNr.setCellValueFactory(new PropertyValueFactory<>("episodeNr"));
            col_epName.setCellValueFactory(new PropertyValueFactory<>("episodeName"));
            col_avgPctWatched.setCellValueFactory(new PropertyValueFactory<>("avgPctWatched"));

            // Set data to TableView.
            tableOverview2.setItems(overview2DAO.getAllRecords(comboBoxSeries.getSelectionModel().getSelectedItem(),
                    comboBoxAccounts.getSelectionModel().getSelectedItem()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
