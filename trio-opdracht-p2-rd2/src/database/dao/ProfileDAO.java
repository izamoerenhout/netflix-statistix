package database.dao;

import appLogic.Account;
import appLogic.Profile;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProfileDAO {

    private DatabaseConnector databaseConnector;

    public ProfileDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    // Retrieves all profiles from the database.
    public ObservableList<Profile> getAllProfiles() {
        // Instantiate profileList.
        ObservableList<Profile> profileList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT Profile.AccountId, Account.Name, Profile.ProfileName, Profile.Age \n" +
                    "FROM Profile \n" +
                    "JOIN Account \n" +
                    "ON Account.AccountId = Profile.AccountId;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate through ResultSet, put data into new Profile object and add to list.
            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String accountName = resultSet.getString("Name");
                String profileName = resultSet.getString("ProfileName");
                int age = resultSet.getInt("Age");

                profileList.add(new Profile(accountId, accountName, profileName, age));
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

    // Updates the id of an existing account in the database.
    public boolean updateAccountId(int profileAccountId, String profileName) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Profile \n" +
                            "SET AccountId = %d \n" +
                            "WHERE ProfileName = '%s';",
                    profileAccountId,
                    profileName);

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

    // Inserts a new profile into the database.
    public boolean insertProfile(int id, String profileName, int age) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO Profile (AccountId, ProfileName, Age) VALUES('%d', '%s', '%d');",
                    id,
                    profileName,
                    age);

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

    // Deletes a profile from the database.
    public boolean deleteProfile(int id, String profileName) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "DELETE FROM Profile WHERE AccountId = " + id + " AND ProfileName = '" + profileName + "'";

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
}
