package database.dao;

import appLogic.Profile;
import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfileDAO {

    private DatabaseConnector databaseConnector;

    public ProfileDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
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
