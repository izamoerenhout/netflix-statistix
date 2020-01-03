package database;

import appLogic.Profile;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class ProfileDAO {

    private DatabaseConnection databaseConnection;

    public ProfileDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Retrieves all profiles from a specific account.
    public ArrayList<Profile> getAccountProfiles(int id) {
        ArrayList<Profile> profileList = new ArrayList<>();

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT * FROM Profile WHERE accountId = " + id;

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String profileName = resultSet.getString("ProfileName");
                int age = resultSet.getInt("Age");

                profileList.add(new Profile(accountId, profileName, age));
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

    // Updates an existing profile in the database.
    public boolean updateProfile(String profileName, int age, int id) {
        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Profile SET ProfileName = '%s', Age = '%d' WHERE AccountId = %d",
                    profileName,
                    age,
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

    // Inserts a new profile into the database.
    public boolean insertProfile(int id, String profileName, int age) {
        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

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
        Connection connection = databaseConnection.getConnection();

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
