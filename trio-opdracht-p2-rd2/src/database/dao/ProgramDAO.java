package database.dao;

import appLogic.Episode;
import appLogic.Movie;
import appLogic.Program;
import database.DatabaseConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProgramDAO {

    private DatabaseConnector databaseConnector;

    public ProgramDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    // Retrieves a program from the database
    public Program getProgramById(int id) {
        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        Program program = null;

        try {
            // Form three SQL queries that will search for programs based on the given id.
            String programQuery = "SELECT * FROM Program WHERE ProgramId = " + id;
            String episodeQuery = "SELECT * FROM Episode WHERE ProgramId = " + id;
            String movieQuery = "SELECT * FROM Movie WHERE ProgramId = " + id;

            // Create statements that will execute the above queries.
            Statement programStatement = connection.createStatement();
            Statement episodeStatement = connection.createStatement();
            Statement movieStatement = connection.createStatement();

            // Execute the queries. The results will be stored in the following variables.
            ResultSet programResultSet = programStatement.executeQuery(programQuery);
            ResultSet episodeResultSet = episodeStatement.executeQuery(episodeQuery);
            ResultSet movieResultSet = movieStatement.executeQuery(movieQuery);

            // Initialising variables to store results into.
            int programId = 0;
            String programName = "";
            String length = "";

            while (programResultSet.next()) {
                programId = programResultSet.getInt("ProgramId");
                programName = programResultSet.getString("ProgramName");
                length = programResultSet.getString("Length");

            }

            while (episodeResultSet.next()) {
                int episodeProgramId = episodeResultSet.getInt("ProgramId");
                String episodeNr = episodeResultSet.getString("EpisodeNr");
                String seriesTitle = episodeResultSet.getString("SeriesTitle");

                program = new Episode(episodeProgramId, programName, length, episodeNr, seriesTitle);
            }

            while (movieResultSet.next()) {
                int movieProgramId = movieResultSet.getInt("ProgramId");
                String genre = movieResultSet.getString("Genre");
                String language = movieResultSet.getString("Language");
                String ageRating = movieResultSet.getString("AgeRating");

                program = new Movie(movieProgramId, programName, length, genre, language, ageRating);
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

        return program;
    }
}
