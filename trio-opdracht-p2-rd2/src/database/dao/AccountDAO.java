package database.dao;

import appLogic.Account;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for the Accounts screen. */
public class AccountDAO {
    private DatabaseConnector databaseConnector;

    /** Constructor class.
     *
     * @param databaseConnector Instantiates a new Database Connector.
     */
    public AccountDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves all accounts from the database.
     *
     * @return ObservableList that will be stored in a TableView.
     */
    public ObservableList<Account> getAllAccounts() {
        // Instantiate accountList.
        ObservableList<Account> accountList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT * " +
                    "FROM Account;";

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

    /** Updates the name of an existing account in the database.
     *
     * @param name The new name entered in the TableView cell, which will be put into the SET clause.
     * @param email The corresponding email address of that account, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateAccountName(String name, String email) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE account " +
                            "SET name = '%s' " +
                            "WHERE email = '%s';",
                            name,
                            email);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the update.
            statement.executeUpdate(query);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Updates the address of an existing account in the database.
     *
     * @param address The new address entered in the TableView cell, which will be put into the SET clause.
     * @param email The corresponding email address of that account, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateAccountAddress(String address, String email) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE account " +
                            "SET address = '%s' " +
                            "WHERE email = '%s';",
                            address,
                            email);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the update.
            statement.executeUpdate(query);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Updates the city of an existing account in the database.
     *
     * @param city The new city entered in the TableView cell, which will be put into the SET clause.
     * @param email The corresponding email address of that account, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateAccountCity(String city, String email) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE account " +
                            "SET city = '%s' " +
                            "WHERE email = '%s'",
                            city,
                            email);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the update.
            statement.executeUpdate(query);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Inserts a new account into the database
     *
     * @param email The user's registered email address.
     * @param name The user's full name.
     * @param address The user's full address, consisting of street name, house number and suffix.
     * @param city The user's city of residence.
     * @return True or false depending on whether the insertion was successful or not.
     */
    public boolean insertAccount(String email, String name, String address, String city) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO account (email, name, address, city) " +
                            "VALUES('%s', '%s', '%s', '%s');",
                            email,
                            name,
                            address,
                            city);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the insertion.
            statement.executeUpdate(query);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /** Deletes an existing account from the database.
     *
     * @param email
     * @return true or false depending on whether the deletion was successful or not.
     */
    public boolean deleteAccount(String email) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("DELETE FROM account " +
                            "WHERE email = '%s';",
                            email);


            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the insertion.
            statement.execute(query);

            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
