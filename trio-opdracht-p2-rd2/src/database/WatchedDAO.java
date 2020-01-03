package database;

import appLogic.Watched;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class WatchedDAO {

    private DatabaseConnection databaseConnection;

    public WatchedDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    public ArrayList<Watched> getAllWatchedProgramsOfProfile(int accId, String name) {
        ArrayList<Watched> watchedProgramsList = new ArrayList<>();

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {

            // Form an SQL query.
            String query = "SELECT * FROM Watched WHERE AccountId = " + accId + " AND ProfileName = '" + name + "'";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int accountId = resultSet.getInt("AccountId");
                String profileName = resultSet.getString("ProfileName");
                int programId = resultSet.getInt("ProgramId");
                int perctWatched = resultSet.getInt("PerctWatched");

                watchedProgramsList.add(new Watched(accountId, profileName, programId, perctWatched));

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

        return watchedProgramsList;
    }

    // Updates an existing watched program in the database.
    public boolean updateWatched(int perctWatched, int accId, String name, int progId) {
        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE Watched SET PerctWatched = %d WHERE AccountId = %d AND ProfileName = '%s' AND ProgramId = %d",
                    perctWatched,
                    accId,
                    name,
                    progId);

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

    // Inserts a new watched program into the database.
    public boolean insertWatched(int accountId, String profileName, int programId, int perctWatched) {
        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO Watched (AccountId, ProfileName, ProgramId, PerctWatched) VALUES('%d', '%s', '%d', '%d')",
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
        Connection connection = databaseConnection.getConnection();

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
