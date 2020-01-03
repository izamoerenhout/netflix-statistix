package database;

import appLogic.Movie;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashSet;
import java.util.Set;

public class MovieDAO {

    private DatabaseConnection databaseConnection;

    public MovieDAO(DatabaseConnection databaseConnection) {
        this.databaseConnection = databaseConnection;
    }

    // Retrieves all movies from the database.
    public Set<Movie> getAllMovies() {
        Set<Movie> movieList = new HashSet<>();

        // Connect to the database.
        Connection connection = databaseConnection.getConnection();

        try {
            // Form a query.
            String query = "SELECT Movie.ProgramId, Program.ProgramName, Movie.AgeRating, Movie.Genre, Movie.Language, Program.Length \n" +
                    "FROM Movie \n" +
                    "JOIN Program \n" +
                    "ON Program.ProgramId = Movie.ProgramId";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int programId = resultSet.getInt("ProgramId");
                String programName = resultSet.getString("ProgramName");
                String ageRating = resultSet.getString("AgeRating");
                String genre = resultSet.getString("Genre");
                String language = resultSet.getString("Language");
                String length = resultSet.getString("Length");

                movieList.add(new Movie(programId, programName, length, genre, language, ageRating));
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

        return movieList;
    }
}
