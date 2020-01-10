package gui.logic;

import appLogic.Profile;
import database.DatabaseConnector;
import database.dao.ProfileDAO;
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

public class ProfilesScreenController implements Initializable {

    public Stage stage;

    public TextField idInput;
    public TextField profileNameInput;
    public TextField ageInput;
    public TableView<Profile> tableProfile;
    public TableColumn<Profile, Integer> col_id;
    public TableColumn<Profile, String> col_accountName;
    public TableColumn<Profile, String> col_profileName;
    public TableColumn<Profile, Integer> col_age;
    public Button buttonAdd;
    public Button buttonBack;

    private ObservableList<Profile> list;

    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Retrieving profiles from the database...");

        // Retrieve profiles from database and put them into the TableView.
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
            String query = "SELECT Profile.AccountId, Account.Name, Profile.ProfileName, Profile.Age \n" +
                    "FROM Profile \n" +
                    "JOIN Account \n" +
                    "ON Account.AccountId = Profile.AccountId;";

            // Create a statement that will be used to execute the query.
            Statement statement = con.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate through ResultSet, put data into new Profile object and add to list.
            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String accountName = resultSet.getString("Name");
                String profileName = resultSet.getString("ProfileName");
                int age = resultSet.getInt("Age");

                list.add(new Profile(accountId, accountName, profileName, age));
            }

            // Set property to TableView columns.
            col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_accountName.setCellValueFactory(new PropertyValueFactory<>("accountName"));
            col_profileName.setCellValueFactory(new PropertyValueFactory<>("profileName"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));

            // Set data to TableView.
            tableProfile.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Calls the insertProfile method from ProfileDAO and adds a new profile into the database.
    public void addProfile() {
        ProfileDAO profile = new ProfileDAO(new DatabaseConnector());

        // Convert the user input in the fields "Account Id" and "Age" to an int
        // in order to store them into a new Profile object.
        int id = Integer.parseInt(idInput.getText());
        int age = Integer.parseInt(ageInput.getText());

        boolean successful = profile.insertProfile(id, profileNameInput.getText(), age);

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Profile creation success");
            success.setHeaderText(null);
            success.setContentText("Profile has been added successfully.");
            success.show();
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Profile creation failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to add profile");
            failed.show();
        }
    }
}
