package database.dao;

import appLogic.Profile;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for the Profiles screen. */
public class ProfileDAO {
    private DatabaseConnector databaseConnector;

    /** Class constructor.
     *
     * @param databaseConnector Instantiates a new Database Connector.
     */
    public ProfileDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves all profiles from the database.
     *
     * @return ObservableList that will be stored in a TableView.
     */
    public ObservableList<Profile> getAllProfiles() {
        // Instantiate profileList.
        ObservableList<Profile> profileList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT profile.email, account.name, profile.profile_name, profile.age " +
                    "FROM profile " +
                    "JOIN account " +
                    "ON account.email = profile.email;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate through ResultSet, put data into new Profile object and add to list.
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String accountName = resultSet.getString("name");
                String profileName = resultSet.getString("profile_name");
                int age = resultSet.getInt("age");

                profileList.add(new Profile(email, accountName, profileName, age));
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

    /** Updates the email of an existing profile in the database.
     *
     * @param profileEmail The new email address entered into the TableView cell, which will be put into the SET clause.
     * @param profileName The corresponding profile name of that account, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateProfileEmail(String profileEmail, String profileName) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE profile " +
                            "SET email = '%s' " +
                            "WHERE profile_name = '%s';",
                            profileEmail,
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

    /** Updates the profile name of an existing profile in the database.
     *
     * @param newProfileName The new profile name entered into the TableView cell, which will be put into the SET clause.
     * @param profileEmail The corresponding email address of that profile, which will be put into the WHERE clause.
     * @param currentProfileName The corresponding age of that profile, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateProfileName(String newProfileName, String profileEmail, String currentProfileName, int age) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE profile " +
                            "SET profile_name = '%s' " +
                            "WHERE email = '%s' AND profile_name = '%s' AND age = %d;",
                            newProfileName,
                            profileEmail,
                            currentProfileName,
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

    /** Updates the profile name of an existing profile in the database.
     *
     * @param age The new age entered into the TableView cell, which will be put into the SET clause.
     * @param email The corresponding email address of that profile, which will be put into the WHERE clause.
     * @param profileName The corresponding profile name of that profile, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateProfileAge(int age, String email, String profileName) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE profile " +
                            "SET age = %d " +
                            "WHERE email = '%s' AND profile_name = '%s';",
                            age,
                            email,
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

    /** Inserts a new profile into the database.
     *
     * @param email The user's registered email address.
     * @param profileName The user's profile name.
     * @param age The user's age.
     * @return True or false depending on whether the insertion was successful or not.
     */
    public boolean insertProfile(String email, String profileName, int age) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO profile (email, profile_name, age) " +
                            "VALUES('%s', '%s', '%d');",
                            email,
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

    /** Deletes an existing profile from the database.
     *
     * @param email The profile's email address, which will be put into the WHERE clause.
     * @param profileName The profile's name, which will be put into the WHERE clause.
     * @param age The profile's age, which will be put into the WHERE clause.
     * @return true or false depending on whether the deletion was successful or not.
     */
    public boolean deleteProfile(String email, String profileName, int age) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("DELETE FROM profile " +
                            "WHERE email = '%s' AND profile_name = '%s' AND age = %d;",
                    email,
                    profileName,
                    age);


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
