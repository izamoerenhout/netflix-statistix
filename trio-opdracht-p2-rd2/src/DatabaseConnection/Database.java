package DatabaseConnection;

import Backend.Account;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {

    private final String connectionUrl = "jdbc:sqlserver://localhost\\MSSQLDEV2017;databaseName=Netflix Statistix;integratedSecurity=true;";

    public Database() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC driver was not found.");
        }
    }

    public Account get(int id) {
        String name = "";
        String address = "";
        String city = "";

        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM Account WHERE AccountId=?;");
            statement.setInt(1, id);
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

        return new Account(id, name, address, city);

    }

    public List<Account> getAll() {
        ArrayList<Account> accounts = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(connectionUrl);
            PreparedStatement statement = conn.prepareStatement("SELECT * FROM Account;");
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                int id = result.getInt("AccountId");
                String name = result.getString("Name");
                String address = result.getString("Address");
                String city = result.getString("City");

                accounts.add(new Account(id, name, address, city));
            }

            conn.close();

        } catch (SQLException e) {
            System.out.println("Error while getting all accounts.");
        }

        return accounts;

    }
}