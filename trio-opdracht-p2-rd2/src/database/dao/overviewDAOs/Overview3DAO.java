package database.dao.overviewDAOs;

import appLogic.overviewModelObjects.Overview3;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for Overview 3. */
public class Overview3DAO {
    private DatabaseConnector databaseConnector;

    /** Constructor class.
     *
     * @param databaseConnector Instantiates a new Database Connector.
     */
    public Overview3DAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves all records from the database.
     *
     * @param accountEmail The account's email address, which will be put into the WHERE clause.
     * @return ObservableList containing all records as Overview3 objects.
     */
    public ObservableList<Overview3> getAllRecords(String accountEmail) {
        // Instantiate recordList.
        ObservableList<Overview3> recordList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("SELECT watched_program.email, watched_program.profile_name, watched_program.program_id, program.program_name AS 'movie_name' " +
                            "FROM watched_program " +
                            "JOIN movie " +
                            "ON movie.program_id = watched_program.program_id " +
                            "JOIN program " +
                            "ON program.program_id = watched_program.program_id " +
                            "WHERE watched_program.email = '%s' ",
                            accountEmail);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                String profileName = resultSet.getString("profile_name");
                int programId = resultSet.getInt("program_id");
                String movieName = resultSet.getString("movie_name");

                recordList.add(new Overview3(email, profileName, programId, movieName));
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

        return recordList;
    }

    /** Retrieves the email addresses of all accounts from the database.
     *
     * @return ObservableList containing all account's email addresses as Strings.
     */
    public ObservableList<String> getAllAccountEmails() {
        // Instantiate seriesTitleList.
        ObservableList<String> accountEmailList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT email " +
                    "FROM account;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                accountEmailList.add(resultSet.getString("email"));
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

        return accountEmailList;
    }
}
