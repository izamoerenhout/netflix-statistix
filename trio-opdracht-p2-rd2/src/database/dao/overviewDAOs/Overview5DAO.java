package database.dao.overviewDAOs;

import appLogic.Account;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for Overview 5. */
public class Overview5DAO {
    private DatabaseConnector databaseConnector;

    /** Class constructor.
     *
     * @param databaseConnector Instantiates a new database connector.
     */
    public Overview5DAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves all accounts that only have one profile from the database.
     *
     * @return An observable list containing accounts that have only 1 profile. Stored as Account objects.
     */
    public ObservableList<Account> getAllAccountsWith1Profile() {
        // Instantiate accountList.
        ObservableList<Account> accountList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT account.email, account.name, account.address, account.city " +
                    "FROM Account " +
                    "JOIN profile " +
                    "ON profile.email = account.email " +
                    "GROUP BY account.email, account.name, account.address, account.city " +
                    "HAVING COUNT(profile.profile_name) = 1;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String name = resultSet.getString("name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");

                accountList.add(new Account(email, name, address, city));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        return accountList;
    }
}
