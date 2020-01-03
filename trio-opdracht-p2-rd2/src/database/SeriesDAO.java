package database;

import appLogic.Series;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class SeriesDAO {

    private DatabaseConnection databaseConnection;

    public SeriesDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Retrieves a series from the database.
    public Series getSeriesById(String title) {
        Series series = null;

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {

            // Form an SQL query.
            String query = "SELECT * FROM Series WHERE SeriesTitle = '" + title + "'";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String seriesTitle = resultSet.getString("SeriesTitle");
                String genre = resultSet.getString("Genre");
                String language = resultSet.getString("Language");
                String ageRating = resultSet.getString("AgeRating");
                String suggestion = resultSet.getString("Suggestion");

                series = new Series(seriesTitle, genre, language, ageRating, suggestion);
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

        return series;
    }

    public Set<Series> getAllMovies() {
        Set<Series> seriesList = new HashSet<>();

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form a query.
            String query = "SELECT * FROM Series";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String seriesTitle = resultSet.getString("SeriesTitle");
                String genre = resultSet.getString("Genre");
                String language = resultSet.getString("Language");
                String ageRating = resultSet.getString("AgeRating");
                String suggestion = resultSet.getString("Suggestion");

                seriesList.add(new Series(seriesTitle, genre, language, ageRating, suggestion));
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

        return seriesList;
    }
}
