package kcz.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class Dao {
    protected String dbUrl = "jdbc:sqlite:gym-journal.db";

    protected Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl);
    }

    protected void closeConnection(Connection connection) throws SQLException {
        if (connection != null) {
            connection.close();
        }
    }

    public void setDbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }
}
