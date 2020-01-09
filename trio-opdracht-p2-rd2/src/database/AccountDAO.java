package database;

import appLogic.Account;
import appLogic.Profile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class AccountDAO {

    private DatabaseConnection databaseConnection;

    public AccountDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Retrieves a single account from the database.
    public Account getAccountById(int id) {
        Account account = null;

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {

            // Form an SQL query.
            String query = "SELECT * FROM Account WHERE AccountId = " + id;

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String name = resultSet.getString("Name");
                String address = resultSet.getString("Address");
                String city = resultSet.getString("City");

                account = new Account(accountId, name, address, city);

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

        return account;
    }

    // Retrieves all accounts from the database.
    public ArrayList<Account> getAllAccounts() {
        ArrayList<Account> accountList = new ArrayList<>();

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {

            // Form an SQL query.
            String query = "SELECT * FROM Account";

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
    public boolean updateAccount(String name, String address, String city, int id) {
        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Account SET Name = '%s', Address = '%s', City = '%s' WHERE AccountId = %d",
                    name,
                    address,
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

    // Updates the name of an existing account in the database.
    public boolean updateAccountName(String name, int id) {
        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Account SET Name = '%s' WHERE AccountId = %d",
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
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Account SET Address = '%s' WHERE AccountId = %d",
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

    // Updates the name of an existing account in the database.
    public boolean updateAccountCity(String city, int id) {
        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Account SET City = '%s' WHERE AccountId = %d",
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
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO Account (Name, Address, City) VALUES('%s', '%s', '%s');",
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
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = "DELETE FROM Account WHERE AccountId = " + id;

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

    // Retrieves all profiles from the database.
    public ArrayList<Profile> getAllProfiles() {
        ArrayList<Profile> profileList = new ArrayList<>();

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT Account.AccountId, Account.Name, Profile.Age \n" +
                    "FROM Account \n" +
                    "JOIN Profile \n" +
                    "ON Account.AccountId = Profile.AccountId";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String name = resultSet.getString("Name");
                int age = resultSet.getInt("Age");

                profileList.add(new Profile(accountId, name, age));
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

        return profileList;
    }
}
