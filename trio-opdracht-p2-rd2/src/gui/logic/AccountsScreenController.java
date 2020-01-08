package gui.logic;

import appLogic.Account;
import database.AccountDAO;
import database.DatabaseConnection;
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

    private ObservableList<Account> list;

    public void returnToMainMenu() throws Exception {
        stage = Main.getPrimaryStage();

        Parent root = FXMLLoader.load(getClass().getResource("/gui/fxml/MainMenu.fxml"));

        stage.setScene(new Scene(root));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Retrieving accounts from the database...");

        // Retrieve accounts from database and put them into the TableView.
        populateTableView();
    }

    // Method responsible for populating TableView with records from our database.
    private void populateTableView() {
        // Instantiate list.
        list = FXCollections.observableArrayList();

        try {
            // Connect to the database.
            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLDEV2017;databaseName=Netflix Statistix;integratedSecurity=true;");
//            Connection connection = DriverManager.getConnection("jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix Statistix;integratedSecurity=true;");

            // Form an SQL query.
            String query = "SELECT * FROM Account";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate through ResultSet, put data into new Account object and add to list.
            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");

                list.add(new Account(accountId, name, address, city));
            }

            // Set property to TableView columns.
            col_id.setCellValueFactory(new PropertyValueFactory<>("accountId"));
            col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
            col_address.setCellValueFactory(new PropertyValueFactory<>("address"));
            col_city.setCellValueFactory(new PropertyValueFactory<>("city"));

            // Set data to TableView.
            tableAccount.setItems(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Calls the insertAccount method from AccountDAO and adds a new account into the database.
    public void addAccount() {
        AccountDAO account = new AccountDAO(new DatabaseConnection());
        boolean successful = account.insertAccount(nameInput.getText(), addressInput.getText(), cityInput.getText());

        if (successful) {
            Alert success = new Alert(Alert.AlertType.INFORMATION);
            success.setTitle("Account creation success");
            success.setHeaderText(null);
            success.setContentText("Account has been added successfully.");
            success.show();
            populateTableView();
        } else {
            Alert failed = new Alert(Alert.AlertType.WARNING);
            failed.setTitle("Account creation failed");
            failed.setHeaderText(null);
            failed.setContentText("Failed to add account.");
            failed.show();
        }
    }
}
