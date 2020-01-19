package database.dao.overviewDAOs;

import domain.overviewDomain.Overview6;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for Overview 6. */
public class Overview6DAO {
    private DatabaseConnector databaseConnector;

    /** Class constructor.
     *
     * @param databaseConnector Instantiates a new database connector.
     */
    public Overview6DAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public ObservableList<Overview6> getRecord(String movieName) {
        // Instantiate recordList.
        ObservableList<Overview6> recordList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("SELECT program.program_id, program.program_name AS 'movie_name', COUNT(watched_program.pct_watched) AS 'amount_of_viewers' " +
                    "FROM watched_program " +
                    "JOIN movie " +
                    "ON movie.program_id = watched_program.program_id " +
                    "JOIN program " +
                    "ON program.program_id = watched_program.program_id " +
                    "WHERE program.program_name = '%s' " +
                    "GROUP BY program.program_id, program.program_name, watched_program.pct_watched " +
                    "HAVING watched_program.pct_watched = 100;",
                    movieName);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int programId = resultSet.getInt("program_id");
                String movie = resultSet.getString("movie_name");
                int amountOfViewers = resultSet.getInt("amount_of_viewers");

                recordList.add(new Overview6(programId, movie, amountOfViewers));
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

    public ObservableList<String> getAllMovieTitles() {
        // Instantiate movieTitleList.
        ObservableList<String> movieTitleList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT program_name " +
                    "FROM program " +
                    "JOIN movie " +
                    "ON movie.program_id = program.program_id;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                movieTitleList.add(resultSet.getString("program_name"));
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

        return movieTitleList;
    }
}
