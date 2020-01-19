package gui.logic.overviewControllers;

import domain.overviewDomain.Overview4;
import database.DatabaseConnector;
import database.dao.overviewDAOs.Overview4DAO;
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
import java.sql.Time;
import java.util.ResourceBundle;

/** Controller for Overview 4. */
public class Overview4Controller implements Initializable {
    public Stage stage;
    public Button buttonBack;

    public TableView<Overview4> tableOverview4;
    public TableColumn<Overview4, Integer> col_progId;
    public TableColumn<Overview4, String> col_movieName;
    public TableColumn<Overview4, Integer> col_ageRating;
    public TableColumn<Overview4, Time> col_length;

    /** Returns to the Overview Selection screen. */
    public void returnToOverviewSelectionScreen() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/OverviewSelectionScreen.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Every time this scene is shown, populateTableView will be called and populates the TableView with the longest
     * movie with an age rating below 16. */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        populateTableView();
    }

    /** Populates the TableView with the longest movie with an age rating below 16. */
    public void populateTableView() {
        Overview4DAO overview4DAO = new Overview4DAO(new DatabaseConnector());

        try {
            // Set attributes to TableView columns.
            col_progId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_movieName.setCellValueFactory(new PropertyValueFactory<>("movieName"));
            col_ageRating.setCellValueFactory(new PropertyValueFactory<>("ageRating"));
            col_length.setCellValueFactory(new PropertyValueFactory<>("length"));

            // Set attributes to TableView columns.
            tableOverview4.setItems(overview4DAO.getRecord());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
