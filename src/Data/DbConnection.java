package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
    private static DbConnection instance;
    private Connection connection;
    private String url = "jdbc:mysql://localhost:3306/Homework?allowPublicKeyRetrieval=true&useSSL=false";
    private String usr = "root";
    private String pwd = "my-secret-pw";

    private DbConnection() {
    }

    public static DbConnection getInstance() {
        if (instance == null) {
            instance = new DbConnection();
        }
        return instance;
    }

    public void openConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            if (this.connection == null || this.connection.isClosed()) {
                this.connection = DriverManager.getConnection(url, usr, pwd);
            }
        } catch (SQLException e) {
            System.out.println("Cannot open database connection: " + e.getMessage());
        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }

    public void closeConnection() {
        try {
            if (this.connection != null && !this.connection.isClosed()) {
                this.connection.close();
            }
        } catch (SQLException e) {
            System.out.println("Cannot close database connection: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return this.connection;
    }
}
