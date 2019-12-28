package DatabaseConnection;

import java.sql.*;

public class DatabaseConnection {
    private String connectionUrl;
    private Connection con;
    private Statement stmt;
    private ResultSet rs;
    private StringBuilder sb;

    public DatabaseConnection() {
        connectionUrl = "jdbc:sqlserver://localhost\\MSSQLDEV2017;databaseName=Netflix Statistix;integratedSecurity=true;";
        con = null;
        stmt = null;
        rs = null;
        sb = new StringBuilder();
    }

    public String execute() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            con = DriverManager.getConnection(connectionUrl);

            String SQL = "SELECT Episode.EpisodeNr, Program.ProgramName, AVG(Watched.PerctWatched) AS 'AVG % Watched'\n" +
                    "FROM Watched\n" +
                    "INNER JOIN Program\n" +
                    "ON Program.ProgramId = Watched.ProgramId\n" +
                    "INNER JOIN Episode\n" +
                    "ON Episode.ProgramId = Program.ProgramId\n" +
                    "INNER JOIN Series\n" +
                    "ON Series.SeriesTitle = Episode.SeriesTitle\n" +
                    "WHERE Series.SeriesTitle = 'Breaking Bad'\n" +
                    "GROUP BY Episode.EpisodeNr, Program.ProgramName\n" +
                    "ORDER BY Episode.EpisodeNr ASC";

            stmt = con.createStatement();

            rs = stmt.executeQuery(SQL);

            while (rs.next()) {
                String episodeNr = rs.getString("EpisodeNr");
                String programName = rs.getString("ProgramName");
                int avgPerctWatched = rs.getInt("AVG % Watched");

                sb.append(episodeNr + " /// " + programName + " /// " + avgPerctWatched + "\n");
            }
        }

        catch (Exception e) {
            e.printStackTrace();
        }

        finally {
            if (rs != null) try { rs.close(); } catch(Exception e) {}
            if (stmt != null) try { stmt.close(); } catch(Exception e) {}
            if (con != null) try { con.close(); } catch(Exception e) {}
        }

        return sb.toString();
    }
}