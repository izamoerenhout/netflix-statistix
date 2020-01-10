package database.dao;

import appLogic.Watched;
import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class WatchedDAO {

    private DatabaseConnector databaseConnector;

    public WatchedDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    // Inserts a new watched program into the database.
    public boolean insertWatched(int accountId, String profileName, int programId, int perctWatched) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO Watched (AccountId, ProfileName, ProgramId, PerctWatched) " +
                            "VALUES('%d', '%s', '%d', '%d')",
                    accountId,
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
    public boolean deleteWatched(int accountId, String profileName, int programId) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("DELETE FROM Watched WHERE AccountId = %d AND ProfileName = '%s' AND ProgramId = %d",
                    accountId,
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
