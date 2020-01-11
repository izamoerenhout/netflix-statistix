package database.dao;

import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.Statement;

public class WatchedDAO {
    private DatabaseConnector databaseConnector;

    public WatchedDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    // Inserts a new watched program into the database.
    public boolean insertWatchedProgram(String email, String profileName, int programId, int perctWatched) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO watched_program (email, profile_name, program_id, pct_watched)" +
                            "VALUES('%s', '%s', '%d', '%d');",
                            email,
                            profileName,
                            programId,
                            perctWatched);

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

    // Deletes a watched program from the database.
    public boolean deleteWatchedProgram(String email, String profileName, int programId) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("DELETE FROM watched_program" +
                            "WHERE email = '%s' AND profile_name = '%s' AND program_id = %d;",
                    email,
                    profileName,
                    programId);

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
