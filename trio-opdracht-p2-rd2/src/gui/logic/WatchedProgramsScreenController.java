package gui.logic;

import appLogic.Watched_Program;
import database.DatabaseConnector;
import database.dao.WatchedProgramDAO;
import gui.Main;
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

/** Controller for the Watched Programs screen. */
public class WatchedProgramsScreenController implements Initializable {
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
    public Button buttonDelete;
    public Button buttonBack;

    /** Returns to the Main Menu screen */
    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Gets called when the Watched Programs screen is opened. Prints a line of text, makes the Email, Profile name, Program id
     *      and % watched columns editable and populates the TableView.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Retrieving watched programs from the database...");

        // Make the program id and % watched columns editable.
        tableWatched.setEditable(true);
        col_programId.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        col_pctWatched.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));

        // Retrieve watched programs from database and put them into the TableView.
        populateTableView();
    }

    /** Calls getAllWatchedPrograms from WatchedProgramDAO and populates the TableView. */
    private void populateTableView() {
        WatchedProgramDAO watchedProgramDAO = new WatchedProgramDAO(new DatabaseConnector());

        try {
            // Set property to TableView columns.
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_accountName.setCellValueFactory(new PropertyValueFactory<>("accountName"));
            col_profileName.setCellValueFactory(new PropertyValueFactory<>("profileName"));
            col_programId.setCellValueFactory(new PropertyValueFactory<>("programId"));
            col_pctWatched.setCellValueFactory(new PropertyValueFactory<>("pctWatched"));

            // Set data to TableView.
            tableWatched.setItems(watchedProgramDAO.getAllWatchedPrograms());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Calls insertWatchedProgram from WatchedProgramDAO and populates the TableView. */
    public void addWatchedProgram() {
        WatchedProgramDAO watched = new WatchedProgramDAO(new DatabaseConnector());

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

    /** Calls updateWatchedProgramId from WatchedProgramDAO and updates the program id of an existing watched program in the database. */
    public void onEditUpdateWatchedProgramId(TableColumn.CellEditEvent<Watched_Program, Integer> watchedProgramIntegerCellEditEvent) {
        // Store current program id name in variable.
        Watched_Program watchedProgram = tableWatched.getSelectionModel().getSelectedItem();
        int currentProgramId = watchedProgram.getProgramId();

        // Update value of cell in TableView to new value entered by user.
        int newProgramId = watchedProgramIntegerCellEditEvent.getNewValue();
        watchedProgram.setProgramId(newProgramId);

        // Update value in the database.
        WatchedProgramDAO watchedProgramDAO = new WatchedProgramDAO(new DatabaseConnector());
        boolean successful = watchedProgramDAO.updateWatchedProgramId(newProgramId, currentProgramId,
                watchedProgram.getEmail(), watchedProgram.getProfileName());

        if (successful){
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Watched program update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update program id.");
            failed.show();
        }
    }

    /** Calls updateWatchedProgramPctWatched from WatchedProgramDAO and updates the percentage watched of an existing watched program in the database. */
    public void onEditUpdateWatchedProgramPctWatched(TableColumn.CellEditEvent<Watched_Program, Integer> watchedProgramIntegerCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Watched_Program watchedProgram = tableWatched.getSelectionModel().getSelectedItem();
        watchedProgram.setPctWatched(watchedProgramIntegerCellEditEvent.getNewValue());

        // Update value in the database.
        WatchedProgramDAO watchedProgramDAO = new WatchedProgramDAO(new DatabaseConnector());
        boolean successful = watchedProgramDAO.updateWatchedProgramPctWatched(watchedProgram.getPctWatched(),
                watchedProgram.getProgramId(), watchedProgram.getEmail(), watchedProgram.getProfileName());

        if (successful){
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Watched program update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update program id.");
            failed.show();
        }
    }

    /** Calls deleteWatchedProgram from WatchedProgramDAO and deleted an existing watched program from the database. */
    public void deleteWatchedProgram() {
        Watched_Program watchedProgram = tableWatched.getSelectionModel().getSelectedItem();

        WatchedProgramDAO watchedProgramDAO = new WatchedProgramDAO(new DatabaseConnector());
        boolean successful = watchedProgramDAO.deleteWatchedProgram(watchedProgram.getEmail(), watchedProgram.getProfileName(),
                watchedProgram.getProgramId());

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Watched program deletion success");
            success.setHeaderText(null);
            success.setContentText("Watched program has been deleted successfully.");
            success.show();
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Watched program deletion failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to delete watched program.");
            failed.show();
        }
    }
}
