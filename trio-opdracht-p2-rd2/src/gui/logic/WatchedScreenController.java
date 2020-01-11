package gui.logic;

import appLogic.Watched_Program;
import database.DatabaseConnector;
import database.dao.WatchedDAO;
import gui.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WatchedScreenController implements Initializable {

    public Stage stage;

    public TextField emailInput;
    public TextField profileNameInput;
    public TextField programIdInput;
    public TextField pctWatchedInput;
    public TableView<Watched_Program> tableWatched;
    public TableColumn<Watched_Program, String> col_email;
    public TableColumn<Watched_Program, String> col_accountName;
    public TableColumn<Watched_Program, String> col_profileName;
    public TableColumn<Watched_Program, Integer> col_programId;
    public TableColumn<Watched_Program, Integer> col_pctWatched;
    public Button buttonAdd;
    public Button buttonBack;

    private ObservableList<Watched_Program> list;

    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Retrieving watched programs from the database...");

        // Retrieve watched programs from database and put them into the TableView.
        populateTableView();
    }

    // Method responsible for populating TableView with records from our database.
    private void populateTableView() {
        // Instantiate list.
        list = FXCollections.observableArrayList();

        try {
            // Connect to the database.
            Connection con = new DatabaseConnector().getConnection();

            // Form an SQL query.
            String query = "SELECT watched_program.email, account.name, watched_program.profile_name, watched_program.program_id, watched_program.pct_watched " +
                    "FROM watched_program " +
                    "JOIN account " +
                    "ON account.email = watched_program.email;";

            // Create a statement that will be used to execute the query.
            Statement statement = con.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate through ResultSet, put data into new Watched_Program object and add to list.
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String accountName = resultSet.getString("name");
                String profileName = resultSet.getString("profile_name");
                int programId = resultSet.getInt("program_id");
                int pctWatched = resultSet.getInt("pct_watched");

                list.add(new Watched_Program(email, accountName, profileName, programId, pctWatched));
            }

            // Set property to TableView columns.
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_accountName.setCellValueFactory(new PropertyValueFactory<>("accountName"));
            col_profileName.setCellValueFactory(new PropertyValueFactory<>("profileName"));
            col_programId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_pctWatched.setCellValueFactory(new PropertyValueFactory<>("pctWatched"));

            // Set data to TableView.
            tableWatched.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Calls the insertWatched method from WatchedDAO and adds a new watched program into the database.
    public void addWatchedProgram() {
        WatchedDAO watched = new WatchedDAO(new DatabaseConnector());

        // Convert the user input in the fields "Program id" and "% watched" to an int
        // in order to store them into a new watched_program object.
        int progId = Integer.parseInt(programIdInput.getText());
        int pctWatched = Integer.parseInt(pctWatchedInput.getText());

        boolean successful = watched.insertWatchedProgram(emailInput.getText(), profileNameInput.getText(), progId, pctWatched);

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Watched program creation success");
            success.setHeaderText(null);
            success.setContentText("Watched program has been added successfully.");
            success.show();
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Watched program creation failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to add watched program.");
            failed.show();
        }
    }
}
