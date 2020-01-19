package gui.logic.overviewControllers;

import domain.Account;
import database.DatabaseConnector;
import database.dao.overviewDAOs.Overview5DAO;
import gui.Main;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.net.URL;
import java.util.ResourceBundle;

/** Controller for Overview 5. */
public class Overview5Controller implements Initializable {
    public Stage stage;
    public Button buttonBack;

    public TableView<Account> tableOverview5;
    public TableColumn<Account, String> col_email;
    public TableColumn<Account, String> col_name;
    public TableColumn<Account, String> col_address;
    public TableColumn<Account, String> col_city;

    /** Returns to the Overview Selection screen. */
    public void returnToOverviewSelectionScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/OverviewSelectionScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Every time this scene is shown, populateTableView will be called and populates the TableView with all accounts
     * that only have one profile. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateTableView();
    }

    /** Populates the TableView with all accounts that only have one profile. */
    public void populateTableView() {
        Overview5DAO overview5DAO = new Overview5DAO(new DatabaseConnector());

        try {
            // Set attributes to TableView columns.
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            col_city.setCellValueFactory(new PropertyValueFactory<>("city"));

            // Set attributes to TableView columns.
            tableOverview5.setItems(overview5DAO.getAllAccountsWith1Profile());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
