package gui.logic;

import appLogic.Profile;
import database.DatabaseConnector;
import database.dao.ProfileDAO;
import gui.Main;
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
import java.util.ResourceBundle;

public class ProfilesScreenController implements Initializable {

    public Stage stage;

    public TextField emailInput;
    public TextField profileNameInput;
    public TextField ageInput;
    public TableView<Profile> tableProfile;
    public TableColumn<Profile, String> col_email;
    public TableColumn<Profile, String> col_accountName;
    public TableColumn<Profile, String> col_profileName;
    public TableColumn<Profile, Integer> col_age;
    public Button buttonAdd;
    public Button buttonBack;

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
        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
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
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
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

        // Convert user input to int, otherwise we cannot store it into a new Profile object.
        int age = Integer.parseInt(ageInput.getText());

        boolean successful = profile.insertProfile(emailInput.getText(), profileNameInput.getText(), age);

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Profile creation success");
            success.setHeaderText(null);
            success.setContentText("Profile has been added successfully.");
            success.show();
            populateTableView();
            emailInput.clear();
            profileNameInput.clear();
            ageInput.clear();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Profile creation failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to add profile");
            failed.show();
            emailInput.clear();
            profileNameInput.clear();
            ageInput.clear();
        }
    }

    public void onEditUpdateEmail(TableColumn.CellEditEvent<Profile, String> profileIntegerCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Profile profileEmail = tableProfile.getSelectionModel().getSelectedItem();
        profileEmail.setEmail(profileIntegerCellEditEvent.getNewValue());

        // Update value in the database.
        ProfileDAO profileDAO = new ProfileDAO(new DatabaseConnector());
        boolean successful = profileDAO.updateProfileEmail(profileIntegerCellEditEvent.getNewValue(), profileEmail.getProfileName());

        if (successful){
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Profile update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update profile email.");
            failed.show();
        }
    }

    public void onEditUpdateProfileName(TableColumn.CellEditEvent<Profile, String> profileStringCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Profile profile = tableProfile.getSelectionModel().getSelectedItem();
        profile.setProfileName(profileStringCellEditEvent.getNewValue());

        // Update value in the database.
        ProfileDAO profileDAO = new ProfileDAO(new DatabaseConnector());
        boolean successful = profileDAO.updateProfileName(profileStringCellEditEvent.getNewValue(), profile.getEmail(), profile.getAge());

        // Krijg alleen een fout melding als in Gerda of Lauran wil aanpassen, ik weet niet hoe ik dat moet verhelpen.

        if (successful){
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Profile update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update profile name.");
            failed.show();
        }
    }

    public void onEditUpdateProfileAge(TableColumn.CellEditEvent<Profile, Integer> profileIntegerCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Profile profile = tableProfile.getSelectionModel().getSelectedItem();
        profile.setAge(profileIntegerCellEditEvent.getNewValue());

        // Update value in the database.
        ProfileDAO profileDAO = new ProfileDAO(new DatabaseConnector());
        boolean successful = profileDAO.updateProfileAge(profileIntegerCellEditEvent.getNewValue(), profile.getEmail(), profile.getProfileName());

        if (successful){
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Profile update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update profile age.");
            failed.show();
        }
    }
}
