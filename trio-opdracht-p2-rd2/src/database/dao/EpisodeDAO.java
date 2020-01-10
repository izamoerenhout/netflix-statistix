package database.dao;

import appLogic.Episode;
import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class EpisodeDAO {

    private DatabaseConnector databaseConnector;

    public EpisodeDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    // Retrieves all episodes from the database.
    public Set<Episode> getAllEpisodes() {
        Set<Episode> episodeList = new HashSet<>();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form a query.
            String query = "SELECT Episode.ProgramId, Episode.SeriesTitle, Episode.EpisodeNr, Program.ProgramName, Program.Length \n" +
                    "FROM Episode \n" +
                    "JOIN Program \n" +
                    "ON Episode.ProgramId = Program.ProgramId \n" +
                    "JOIN Series \n" +
                    "ON Episode.SeriesTitle = Series.SeriesTitle";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int programId = resultSet.getInt("ProgramId");
                String seriesTitle = resultSet.getString("SeriesTitle");
                String episodeNr = resultSet.getString("EpisodeNr");
                String programName = resultSet.getString("ProgramName");
                String length = resultSet.getString("Length");

                episodeList.add(new Episode(programId, programName, length, episodeNr, seriesTitle));
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

        return episodeList;
    }
}
