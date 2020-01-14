package gui.logic;

import appLogic.Account;
import database.dao.AccountDAO;
import database.DatabaseConnector;
import gui.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/** Controller for the Accounts screen. */
public class AccountsScreenController implements Initializable {
    public Stage stage;

    public TextField emailInput;
    public TextField nameInput;
    public TextField addressInput;
    public TextField cityInput;

    public TableView<Account> tableAccount;
    public TableColumn<Account, String> col_email;
    public TableColumn<Account, String> col_name;
    public TableColumn<Account, String> col_address;
    public TableColumn<Account, String> col_city;

    public Button buttonAdd;
    public Button buttonDelete;
    public Button buttonBack;

    /** Returns to the Main Menu screen. */
    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    /** Gets called when the Accounts screen is opened. Prints a line of text, makes the Name, Address and City
     *      columns editable and populates the TableView.
     */
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Retrieving accounts from the database...");

        // Make the email, name, address and city column editable.
        tableAccount.setEditable(true);
        col_email.setCellFactory(TextFieldTableCell.forTableColumn());
        col_name.setCellFactory(TextFieldTableCell.forTableColumn());
        col_address.setCellFactory(TextFieldTableCell.forTableColumn());
        col_city.setCellFactory(TextFieldTableCell.forTableColumn());

        // Retrieve accounts from database and put them into the TableView.
        populateTableView();
    }

    /** Calls getAllAccounts from AccountDAO and populates the TableView. */
    private void populateTableView() {
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());

        try {
            // Set attributes to TableView columns.
            col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            col_city.setCellValueFactory(new PropertyValueFactory<>("city"));

            // Set data to TableView.
            tableAccount.setItems(accountDAO.getAllAccounts());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /** Calls insertAccount from AccountDAO and adds a new account into the database. */
    public void addAccount() {
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.insertAccount(emailInput.getText(), nameInput.getText(), addressInput.getText(), cityInput.getText());

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Account creation success");
            success.setHeaderText(null);
            success.setContentText("Account has been added successfully.");
            success.show();
            populateTableView();
            emailInput.clear();
            nameInput.clear();
            addressInput.clear();
            cityInput.clear();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account creation failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to add account.");
            failed.show();
            emailInput.clear();
            nameInput.clear();
            addressInput.clear();
            cityInput.clear();
        }
    }

    /** Calls updateAccountEmail from AccountDAO and updates the email address of an existing account in the database. */
    public void onEditUpdateAccountEmail(TableColumn.CellEditEvent<Account, String> accountStringCellEditEvent) {
        Account account = tableAccount.getSelectionModel().getSelectedItem();
        // Store current email address in variable.
        String currentEmail = account.getEmail();

        // Update value of cell in TableView to new value entered by user.
        account.setEmail(accountStringCellEditEvent.getNewValue());
        String newEmail = account.getEmail();

        // Update value in the database.
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.updateAccountEmail(newEmail, currentEmail);

        if (successful) {
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update account email.");
            failed.show();
        }
    }

    /** Calls updateAccountName from AccountDAO and updates the name of an existing account in the database. */
    public void onEditUpdateAccountName(TableColumn.CellEditEvent<Account, String> accountStringCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Account account = tableAccount.getSelectionModel().getSelectedItem();
        account.setName(accountStringCellEditEvent.getNewValue());

        // Update value in the database.
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.updateAccountName(accountStringCellEditEvent.getNewValue(), account.getEmail());

        if (successful) {
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update account name.");
            failed.show();
        }
    }

    /** Calls updateAccountAddress from AccountDAO and updates the address of an existing account in the database. */
    public void onEditUpdateAccountAddress(TableColumn.CellEditEvent<Account, String> accountStringCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Account account = tableAccount.getSelectionModel().getSelectedItem();
        account.setAddress(accountStringCellEditEvent.getNewValue());

        // Update value in the database.
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.updateAccountAddress(accountStringCellEditEvent.getNewValue(), account.getEmail());

        if (successful) {
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update account address.");
            failed.show();
        }
    }

    /** Calls updateAccountCity from AccountDAO and updates the city of an existing account in the database. */
    public void onEditUpdateAccountCity(TableColumn.CellEditEvent<Account, String> accountStringCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Account account = tableAccount.getSelectionModel().getSelectedItem();
        account.setCity(accountStringCellEditEvent.getNewValue());

        // Update value in the database.
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.updateAccountCity(accountStringCellEditEvent.getNewValue(), account.getEmail());

        if (successful) {
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account update failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to update account city.");
            failed.show();
        }
    }

    /** Calls deleteAccount from AccountDAO and deleted an existing account from the database. */
    public void deleteAccount() {
        Account account = tableAccount.getSelectionModel().getSelectedItem();

        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.deleteAccount(account.getEmail());

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Account deletion success");
            success.setHeaderText(null);
            success.setContentText("Account has been deleted successfully.");
            success.show();
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account deletion failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to delete account.");
            failed.show();
        }
    }
}
