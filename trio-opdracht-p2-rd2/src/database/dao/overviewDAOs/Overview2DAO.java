package database.dao.overviewDAOs;

import appLogic.overviewModelObjects.Overview2;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Overview2DAO {
    private DatabaseConnector databaseConnector;

    /** Constructor class.
     *
     * @param databaseConnector
     */
    public Overview2DAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    public ObservableList<Overview2> getAllRecords(String seriesTitle, String accountEmail) {
        // Instantiate recordList.
        ObservableList<Overview2> recordList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("SELECT account.email, watched_program.program_id, episode.episode_nr, program.program_name AS 'episode_name', AVG(watched_program.pct_watched) AS 'avg_pct_watched' " +
                            "FROM watched_program " +
                            "JOIN episode " +
                            "ON episode.program_id = watched_program.program_id " +
                            "JOIN program " +
                            "ON program.program_id = watched_program.program_id " +
                            "JOIN account " +
                            "ON account.email = watched_program.email " +
                            "WHERE episode.series_title = '%s' AND account.email = '%s' " +
                            "GROUP BY account.email, watched_program.program_id, episode.episode_nr, program.program_name; ",
                            seriesTitle,
                            accountEmail);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String email = resultSet.getString("email");
                int programId = resultSet.getInt("program_id");
                String episodeNr = resultSet.getString("episode_nr");
                String episodeName = resultSet.getString("episode_name");
                int avgPctWatched = resultSet.getInt("avg_pct_watched");

                recordList.add(new Overview2(email, programId, episodeNr, episodeName, avgPctWatched));
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

    public ObservableList<String> getAllSeriesTitles() {
        // Instantiate seriesTitleList.
        ObservableList<String> seriesTitleList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT series_title " +
                    "FROM series;";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                seriesTitleList.add(resultSet.getString("series_title"));
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

        return seriesTitleList;
    }

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
