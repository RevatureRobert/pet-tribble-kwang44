package dev.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

    public static Connection getConnnection() throws SQLException {

        String url = "jdbc:postgresql://localhost:5432/postgres";
        String username = "postgres";
        String password = "112233";

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }


}
