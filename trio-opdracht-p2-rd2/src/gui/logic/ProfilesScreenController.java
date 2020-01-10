package gui.logic;

import appLogic.Profile;
import database.DatabaseConnector;
import database.dao.AccountDAO;
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
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;
import javafx.util.converter.IntegerStringConverter;

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

        // Make the id, profileName and age column editable.
        tableProfile.setEditable(true);
        col_id.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_profileName.setCellFactory(TextFieldTableCell.forTableColumn());
        col_age.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        // Retrieve profiles from database and put them into the TableView.
        populateTableView();
    }

    // Calls the getAllProfiles method from ProfileDAO and populates the TableView.
    private void populateTableView() {
        ProfileDAO profileDAO = new ProfileDAO(new DatabaseConnector());

        try {
            // Set property to TableView columns.
            col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
            col_accountName.setCellValueFactory(new PropertyValueFactory<>("accountName"));
            col_profileName.setCellValueFactory(new PropertyValueFactory<>("profileName"));
            col_age.setCellValueFactory(new PropertyValueFactory<>("age"));

            // Set data to TableView.
            tableProfile.setItems(profileDAO.getAllProfiles());

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
            idInput.clear();
            profileNameInput.clear();
            ageInput.clear();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Profile creation failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to add profile");
            failed.show();
            idInput.clear();
            profileNameInput.clear();
            ageInput.clear();
        }
    }

    public void onEditUpdateId(TableColumn.CellEditEvent<Profile, Integer> profileIntegerCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Profile profileAccountId = tableProfile.getSelectionModel().getSelectedItem();
        profileAccountId.setId(profileIntegerCellEditEvent.getNewValue());

        // Update value in the database.
        ProfileDAO profileDAO = new ProfileDAO(new DatabaseConnector());
        boolean successful = profileDAO.updateAccountId(profileIntegerCellEditEvent.getNewValue(), profileAccountId.getProfileName());

        if (successful){
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Profile update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update profile account id.");
            failed.show();
        }
    }
}
