package gui.logic.overviewControllers;

import appLogic.overviewModelObjects.Overview6;
import database.DatabaseConnector;
import database.dao.overviewDAOs.Overview6DAO;
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

/** Controller for Overview 6. */
public class Overview6Controller implements Initializable {
    public Stage stage;
    public Button buttonBack;

    public ComboBox<String> comboBox;

    public TableView<Overview6> tableOverview6;
    public TableColumn<Overview6, Integer> col_progId;
    public TableColumn<Overview6, String> col_movieName;
    public TableColumn<Overview6, Integer> col_amountOfViewers;

    /** Returns to the Overview Selection screen. */
    public void returnToOverviewSelectionScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/OverviewSelectionScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Every time this scene is shown, populateComboBox will be called and populates the ComboBox with movie titles. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateComboBox();
    }

    /** Calls getAllMovieTitles from Overview6DAO and fills the ComboBox with all movie titles from the database. */
    private void populateComboBox() {
        Overview6DAO overview6DAO = new Overview6DAO(new DatabaseConnector());
        comboBox.setItems(overview6DAO.getAllMovieTitles());
    }

    /** Populates the TableView with the total amount of viewers who have watched the selected movie entirely. */
    public void populateTableView() {
        Overview6DAO overview6DAO = new Overview6DAO(new DatabaseConnector());

        try {
            // Set attributes to TableView columns.
            col_progId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_movieName.setCellValueFactory(new PropertyValueFactory<>("movieName"));
            col_amountOfViewers.setCellValueFactory(new PropertyValueFactory<>("amountOfViewers"));

            // Set attributes to TableView columns.
            // Escape the single quote in "Andy Warhol's Dracula" by adding another single quote in front of it.
            tableOverview6.setItems(overview6DAO.getRecord(comboBox.getSelectionModel().getSelectedItem().replace("'", "''")));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
