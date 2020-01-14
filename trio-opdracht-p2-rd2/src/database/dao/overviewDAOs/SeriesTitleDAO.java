package database.dao.overviewDAOs;

import appLogic.overviewModelObjects.Overview1;
import appLogic.overviewModelObjects.SeriesTitle;
import database.DatabaseConnector;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/** Data Access Object for the series titles that will be stored in the ComboBox of Overview 1. */
public class SeriesTitleDAO {
    private DatabaseConnector databaseConnector;

    /** Constructor class.
     *
     * @param databaseConnector Instantiates a new Database Connector.
     */
    public SeriesTitleDAO(DatabaseConnector databaseConnector) {
        this.databaseConnector = databaseConnector;
    }

    /** Retrieves all series titles from the database. */
    public ObservableList<SeriesTitle> getAllSeriesTitles() {
        // Instantiate seriesTitleList.
        ObservableList<SeriesTitle> seriesTitleList = FXCollections.observableArrayList();

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
                String seriesTitle = resultSet.getString("series_title");

                seriesTitleList.add(new SeriesTitle(seriesTitle));
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
