package DatabaseConnection;

import java.sql.*;

public class DatabaseConnection {
    private String connectionUrl;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;

    public DatabaseConnection() {
        connectionUrl = "jdbc:sqlserver://localhost\\MSSQLDEV2017;databaseName=Netflix Statistix;integratedSecurity=true;";
        con = null;
        stmt = null;
        rs = null;
    }

    public void execute() {
        try {
            // 'Importeer' de driver die je gedownload hebt.
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            // Maak de verbinding met de database.
            con = DriverManager.getConnection(connectionUrl);

            // Stel een SQL query samen.
            String SQL = "SELECT * FROM Series";
            stmt = con.createStatement();
            // Voer de query uit op de database.
            rs = stmt.executeQuery(SQL);

            // Als de resultset waarden bevat dan lopen we hier door deze waarden en printen ze.
            while (rs.next()) {
                // Vraag per row de kolommen in die row op.
                String seriesTitle = rs.getString("SeriesTitle");
                String genre = rs.getString("Genre");
                String language = rs.getString("Language");
                String ageRating = rs.getString("AgeRating");
                String suggestion = rs.getString("Suggestion");

                System.out.println(seriesTitle + ", " + genre + ", " + language + ", " + ageRating + ", " + suggestion);
            }


        }

        // Handle any errors that may have occurred.
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }
    }
}