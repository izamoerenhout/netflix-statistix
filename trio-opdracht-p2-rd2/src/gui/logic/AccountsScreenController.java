package gui.logic;

import appLogic.Account;
import database.dao.AccountDAO;
import database.DatabaseConnector;
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

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class AccountsScreenController implements Initializable {

    public Stage stage;

    public TextField nameInput;
    public TextField addressInput;
    public TextField cityInput;
    public TableView<Account> tableAccount;
    public TableColumn<Account, Integer> col_id;
    public TableColumn<Account, String> col_name;
    public TableColumn<Account, String> col_address;
    public TableColumn<Account, String> col_city;
    public Button buttonAdd;
    public Button buttonBack;

    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Retrieving accounts from the database...");

        // Make the name, address and city column editable.
        tableAccount.setEditable(true);
        col_name.setCellFactory(TextFieldTableCell.forTableColumn());
        col_address.setCellFactory(TextFieldTableCell.forTableColumn());
        col_city.setCellFactory(TextFieldTableCell.forTableColumn());

        // Retrieve accounts from database and put them into the TableView.
        populateTableView();
    }

    // Method responsible for populating TableView with records from our database.
    private void populateTableView() {
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());

        try {
            // Set property to TableView columns.
            col_id.setCellValueFactory(new PropertyValueFactory<>("accountId"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            col_city.setCellValueFactory(new PropertyValueFactory<>("city"));

            // Set data to TableView.
            tableAccount.setItems(accountDAO.getAllAccounts());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Calls the insertAccount method from AccountDAO and adds a new account into the database.
    public void addAccount() {
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.insertAccount(nameInput.getText(), addressInput.getText(), cityInput.getText());

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Account creation success");
            success.setHeaderText(null);
            success.setContentText("Account has been added successfully.");
            success.show();
            populateTableView();
            nameInput.clear();
            addressInput.clear();
            cityInput.clear();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account creation failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to add account.");
            failed.show();
            nameInput.clear();
            addressInput.clear();
            cityInput.clear();
        }
    }

    public void onEditUpdateAccountName(TableColumn.CellEditEvent<Account, String> accountStringCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Account accountName = tableAccount.getSelectionModel().getSelectedItem();
        accountName.setName(accountStringCellEditEvent.getNewValue());

        // Update value in the database.
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.updateAccountName(accountStringCellEditEvent.getNewValue(), accountName.getAccountId());

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

    public void onEditUpdateAccountAddress(TableColumn.CellEditEvent<Account, String> accountStringCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Account accountName = tableAccount.getSelectionModel().getSelectedItem();
        accountName.setAddress(accountStringCellEditEvent.getNewValue());

        // Update value in the database.
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.updateAccountAddress(accountStringCellEditEvent.getNewValue(), accountName.getAccountId());

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

    public void onEditUpdateAccountCity(TableColumn.CellEditEvent<Account, String> accountStringCellEditEvent) {
        // Update value of cell in TableView to new value entered by user.
        Account accountName = tableAccount.getSelectionModel().getSelectedItem();
        accountName.setCity(accountStringCellEditEvent.getNewValue());

        // Update value in the database.
        AccountDAO accountDAO = new AccountDAO(new DatabaseConnector());
        boolean successful = accountDAO.updateAccountCity(accountStringCellEditEvent.getNewValue(), accountName.getAccountId());

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
}
