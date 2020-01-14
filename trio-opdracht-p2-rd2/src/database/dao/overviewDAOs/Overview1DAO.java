package database.dao.overviewDAOs;

import appLogic.Account;
import appLogic.overviewModelObjects.Overview1;
import appLogic.overviewModelObjects.SeriesTitle;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for Overview 1. */
public class Overview1DAO {
    private DatabaseConnector databaseConnector;

    /** Constructor class.
     *
     * @param databaseConnector Instantiates a new Database Connector.
     */
    public Overview1DAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves all records from the database.
     *
     * @param seriesTitle The title of the series selected from the ComboBox.
     * @return ObservableList that will be stored in a TableView.
     */
    public ObservableList<Overview1> getAllRecords(String seriesTitle) {
        // Instantiate recordList.
        ObservableList<Overview1> recordList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = String.format("SELECT watched_program.program_id, episode.episode_nr, program.program_name AS 'episode_name', AVG(watched_program.pct_watched) AS 'avg_pct_watched' " +
                    "FROM watched_program " +
                    "JOIN episode " +
                    "ON episode.program_id = watched_program.program_id " +
                    "JOIN program " +
                    "ON program.program_id = watched_program.program_id " +
                    "WHERE episode.series_title = '%s' " +
                    "GROUP BY watched_program.program_id, episode.episode_nr, program.program_name; ",
                    seriesTitle);

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int programId = resultSet.getInt("program_id");
                String episodeNr = resultSet.getString("episode_nr");
                String episodeName = resultSet.getString("episode_name");
                int avgPctWatched = resultSet.getInt("avg_pct_watched");

                recordList.add(new Overview1(programId, episodeNr, episodeName, avgPctWatched));
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

    /** Retrieves all series titles from the database. */
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
}
