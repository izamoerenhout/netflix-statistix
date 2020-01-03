package database;

import appLogic.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseConnection {

    private final String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLDEV2017;databaseName=Netflix Statistix;integratedSecurity=true;";

    public DatabaseConnection() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver was not found.");
        }
    }

    public Account get(int accountId) {
        String name = "";
        String address = "";
        String city = "";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = conn.prepareStatement("SELECT * " +
                    "FROM Account " +
                    "WHERE AccountId=?;");
            statement.setInt(1, accountId);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                name = result.getString("Name");
                address = result.getString("Address");
                city = result.getString("City");
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while getting account.");
        }

        return new Account(accountId, name, address, city);
    }

    public List<Account> getAll() {
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = conn.prepareStatement("SELECT *" +
                    " FROM Account;");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int accountId = result.getInt("AccountId");
                String name = result.getString("Name");
                String address = result.getString("Address");
                String city = result.getString("City");

                accounts.add(new Account(accountId, name, address, city));
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while getting all accounts.");
        }

        return accounts;
    }

    public boolean createAccount(String name, String address, String city) {
        boolean result = false;

        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = conn.prepareStatement(
                    "INSERT INTO Account (Name, Address, City) " +
                            "VALUES (?, ?, ?)");
            statement.setString(1, name);
            statement.setString(2, address);
            statement.setString(3, city);
            statement.execute();
            result = true;
            conn.close();
        } catch (SQLException e) {
            System.out.println("Error while creating account.");
        }

        return result;
    }
}