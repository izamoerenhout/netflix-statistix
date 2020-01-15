package database.dao.overviewDAOs;

import appLogic.overviewModelObjects.Overview3;
import appLogic.overviewModelObjects.Overview4;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Time;

/** Data Access Object for Overview 4. */
public class Overview4DAO {
    private DatabaseConnector databaseConnector;

    /** Class constructor.
     *
     * @param databaseConnector Instantiates a new Database Connector.
     */
    public Overview4DAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves the longest movie with an age rating below 16 from the database. */
    public ObservableList<Overview4> getRecord() {
        // Instantiate recordList.
        ObservableList<Overview4> recordList = FXCollections.observableArrayList();

        // Connect to the database.
        Connection connection = databaseConnector.getConnection();

        try {
            // Form an SQL query.
            String query = "SELECT TOP 1 movie.program_id, program.program_name AS 'movie_name', movie.age_rating, program.length " +
                            "FROM movie " +
                            "JOIN program " +
                            "ON program.program_id = movie.program_id " +
                            "WHERE age_rating < 16 " +
                            "ORDER BY program.length DESC; ";

            // Create a statement that will be used to execute the query.
            Statement statement = connection.createStatement();

            // Execute the query. The result of the query will be stored in this variable.
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int programId = resultSet.getInt("program_id");
                String movieName = resultSet.getString("movie_name");
                int ageRating = resultSet.getInt("age_rating");
                Time length = resultSet.getTime("length");

                recordList.add(new Overview4(programId, movieName, ageRating, length));
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
}
