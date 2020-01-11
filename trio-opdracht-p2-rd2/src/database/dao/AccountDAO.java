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

    // Updates the name of an existing account in the database.
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

    // Updates the address of an existing account in the database.
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

    // Updates the city of an existing account in the database.
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

    // Inserts a new account into the database.
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

    // Deletes an account from the database.
    public boolean deleteAccount(String email) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("DELETE FROM account " +
                            "WHERE email = '%s';)",
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
