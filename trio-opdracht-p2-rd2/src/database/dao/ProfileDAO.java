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

    // Updates the account email of an existing profile in the database.
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

    // Updates the name of an existing profile in the database.
    public boolean updateProfileName(String profileName, String profileEmail, int age) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE profile " +
                            "SET profile_name = '%s' " +
                            "WHERE email = '%s' AND age = %d;",
                            profileName,
                            profileEmail,
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

    // Updates the age of an existing profile in the database.
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

    // Inserts a new profile into the database.
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

    // Deletes a profile from the database.
    public boolean deleteProfile(String email, String profileName) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("DELETE FROM profile " +
                    "WHERE email = '%s' AND profile_name = '%s';",
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
}
