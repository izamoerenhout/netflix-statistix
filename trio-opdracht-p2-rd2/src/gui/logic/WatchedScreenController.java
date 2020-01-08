package gui.logic;

import appLogic.Watched;
import database.DatabaseConnection;
import database.WatchedDAO;
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
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class WatchedScreenController implements Initializable {

    public Stage stage;

    public TextField idInput;
    public TextField profileNameInput;
    public TextField programIdInput;
    public TextField perctWatchedInput;
    public TableView<Watched> tableWatched;
    public TableColumn<Watched, Integer> col_id;
    public TableColumn<Watched, String> col_profileName;
    public TableColumn<Watched, Integer> col_programId;
    public TableColumn<Watched, Integer> col_perctWatched;
    public Button buttonAdd;
    public Button buttonBack;

    private ObservableList<Watched> list;

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
//            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLDEV2017;databaseName=Netflix Statistix;integratedSecurity=true;");
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix Statistix;integratedSecurity=true;");

            // Form an SQL query.
            String query = "SELECT * FROM Watched";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate through ResultSet, put data into new Watched object and add to list.
            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String profileName = resultSet.getString("ProfileName");
                int programId = resultSet.getInt("ProgramId");
                int perctWatched = resultSet.getInt("PerctWatched");

                list.add(new Watched(accountId, profileName, programId, perctWatched));
            }

            // Set property to TableView columns.
            col_id.setCellValueFactory(new PropertyValueFactory<>("accountId"));
            col_profileName.setCellValueFactory(new PropertyValueFactory<>("profileName"));
            col_programId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_perctWatched.setCellValueFactory(new PropertyValueFactory<>("perctWatched"));

            // Set data to TableView.
            tableWatched.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Calls the insertWatched method from WatchedDAO and adds a new watched program into the database.
    public void addWatched() {
        WatchedDAO watched = new WatchedDAO(new DatabaseConnection());

        // Convert the user input in the fields "Account id", "Program id" and "Perct watched" to an int
        // in order to store them into a new Watched object.
        int id = Integer.parseInt(idInput.getText());
        int progId = Integer.parseInt(programIdInput.getText());
        int perctWatched = Integer.parseInt(perctWatchedInput.getText());

        boolean successful = watched.insertWatched(id, profileNameInput.getText(), progId, perctWatched);

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
