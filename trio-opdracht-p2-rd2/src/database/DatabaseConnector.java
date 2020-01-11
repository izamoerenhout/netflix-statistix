package database;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnector {

    private final String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLDEV2017;databaseName=Netflix Statistix;integratedSecurity=true;";
//    private final String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLSERVER;databaseName=Netflix Statistix;integratedSecurity=true;";
    private Connection connection = null;

    public Connection getConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            connection = DriverManager.getConnection(connectionUrl);
        } catch (Exception e) {
            System.out.println("Unable to connect to the database.");
        }

        return connection;
    }
}