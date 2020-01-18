package database.dao;

import appLogic.WatchedProgram;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for the Watched Programs screen. */
public class WatchedProgramDAO {
    private DatabaseConnector databaseConnector;

    /** Class constructor.
     *
     * @param databaseConnector Instantiates a new Database Connector.
     */
    public WatchedProgramDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves all watched programs from the database.
     *
     * @return ObservableList that will be stored in a TableView.
     */
    public ObservableList<WatchedProgram> getAllWatchedPrograms() {
        // Instantiate watchedProgramList.
        ObservableList<WatchedProgram> watchedProgramList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT watched_program.email, account.name, watched_program.profile_name, watched_program.program_id, watched_program.pct_watched " +
                    "FROM watched_program " +
                    "JOIN account " +
                    "ON account.email = watched_program.email;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            //Iterate through ResultSet, put data into new WatchedProgram object and add to list.
            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String accountName = resultSet.getString("name");
                String profileName = resultSet.getString("profile_name");
                int programId = resultSet.getInt("program_id");
                int pctWatched = resultSet.getInt("pct_watched");

                watchedProgramList.add(new WatchedProgram(email, accountName, profileName, programId, pctWatched));
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

        return watchedProgramList;
    }

    /** Updates the program id of a watched program in the database.
     *
     * @param newProgramId The new program id entered into the TableView cell, which will be put into the SET clause.
     * @param currentProgramId The current program id, which will be put into the WHERE clause.
     * @param email The corresponding email address of the watched program, which will be put into the WHERE clause.
     * @param profileName The corresponding profile name of the watched program, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateWatchedProgramId(int newProgramId, int currentProgramId, String email, String profileName) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE watched_program " +
                            "SET program_id = %d " +
                            "WHERE program_id = %d AND email = '%s' AND profile_name = '%s';",
                    newProgramId,
                    currentProgramId,
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

    /** Updates the program id of a watched program in the database.
     *
     * @param pctWatched The new percentage wachted entered into the TableView cell, which will be put into the SET clause.
     * @param programId The corresponding program id of the watched program, which will be put into the WHERE clause.
     * @param email The corresponding email address of the watched program, which will be put into the WHERE clause.
     * @param profileName The corresponding profile name of the watched program, which will be put into the WHERE clause.
     * @return True or false depending on whether the update was successful or not.
     */
    public boolean updateWatchedProgramPctWatched(int pctWatched, int programId, String email, String profileName) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("UPDATE watched_program " +
                            "SET pct_watched = %d " +
                            "WHERE program_id = %d AND email = '%s' AND profile_name = '%s';",
                    pctWatched,
                    programId,
                    email,
                    profileName);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            if (pctWatched < 0 || pctWatched > 100) {
                return false;
            } else {
                // Execute the update.
                statement.executeUpdate(query);
            }

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

    /** Inserts a new watched program into the database.
     *
     * @param email The user's registered email address.
     * @param profileName The user's profile name.
     * @param programId The program that was watched.
     * @param pctWatched The watched percentage of that program.
     * @return True or false depending on whether the insertion was successful or not.
     */
    public boolean insertWatchedProgram(String email, String profileName, int programId, int pctWatched) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("INSERT INTO watched_program (email, profile_name, program_id, pct_watched) " +
                            "VALUES('%s', '%s', '%d', '%d');",
                            email,
                            profileName,
                            programId,
                            pctWatched);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            if (pctWatched < 0 || pctWatched > 100) {
                return false;
            } else {
                // Execute the update.
                 statement.executeUpdate(query);
            }

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

    /** Deletes an existing watched program from the database.
     *
     * @param email The profile's email address, which will be put into the WHERE clause.
     * @param profileName The profile's name, which will be put into the WHERE clause.
     * @param programId The program id, which will be put into the WHERE clause.
     * @return true or false depending on whether the deletion was successful or not.
     */
    public boolean deleteWatchedProgram(String email, String profileName, int programId) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("DELETE FROM watched_program " +
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
