package gui.logic.overviewControllers;

import appLogic.overviewModelObjects.Overview3;
import database.DatabaseConnector;
import database.dao.overviewDAOs.Overview3DAO;
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

/** Controller for Overview 3. */
public class Overview3Controller implements Initializable {
    public Stage stage;
    public Button buttonBack;

    public ComboBox<String> comboBox;

    public TableView<Overview3> tableOverview3;
    public TableColumn<Overview3, String> col_email;
    public TableColumn<Overview3, String> col_profileName;
    public TableColumn<Overview3, Integer> col_programId;
    public TableColumn<Overview3, String> col_movieName;

    /** Returns to the Overview Selection screen. */
    public void returnToOverviewSelectionScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/OverviewSelectionScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Every time this scene is shown, populateComboBox will be called and populates the ComboBox with emails. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateComboBox();
    }

    /** Calls getAllAccountEmails from Overview3DAO and fills the ComboBox with all account emails from the database. */
    private void populateComboBox() {
        Overview3DAO overview3DAO = new Overview3DAO(new DatabaseConnector());
        comboBox.setItems(overview3DAO.getAllAccountEmails());
    }

    /** Populates the TableView with all records from the database depending on the selected account. */
    public void populateTableView() {
        Overview3DAO overview3DAO = new Overview3DAO(new DatabaseConnector());

        try {
            // Set attributes to TableView columns.
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_profileName.setCellValueFactory(new PropertyValueFactory<>("profileName"));
            col_programId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_movieName.setCellValueFactory(new PropertyValueFactory<>("movieName"));

            // Set attributes to TableView columns.
            tableOverview3.setItems(overview3DAO.getAllRecords(comboBox.getSelectionModel().getSelectedItem()));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
