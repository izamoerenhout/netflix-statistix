package database.dao;

import appLogic.Account;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class AccountDAO {
    private DatabaseConnector databaseConnector;

    public AccountDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    // Retrieves all accounts from the database.
    public ObservableList<Account> getAllAccounts() {
        // Instantiate accountList.
        ObservableList<Account> accountList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT * \n" +
                    " FROM Account;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");

                accountList.add(new Account(accountId, name, address, city));
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

    // Updates the name of an existing account in the database.
    public boolean updateAccountName(String name, int id) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Account \n" +
                            "SET Name = '%s' \n" +
                            "WHERE AccountId = %d;",
                    name,
                    id);

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

    // Updates the address of an existing account in the database.
    public boolean updateAccountAddress(String address, int id) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Account \n" +
                            "SET Address = '%s' \n" +
                            "WHERE AccountId = %d;",
                    address,
                    id);

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

    // Updates the city of an existing account in the database.
    public boolean updateAccountCity(String city, int id) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Account \n" +
                            "SET City = '%s' \n" +
                            "WHERE AccountId = %d",
                    city,
                    id);

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

    // Inserts a new account into the database.
    public boolean insertAccount(String name, String address, String city) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO Account (Name, Address, City) \n" +
                            "VALUES('%s', '%s', '%s');",
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

    // Deletes an account from the database.
    public boolean deleteAccount(int id) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "DELETE FROM Account \n" +
                    "WHERE AccountId = " + id;

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
