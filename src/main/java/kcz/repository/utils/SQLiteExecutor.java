package kcz.repository.utils;

import kcz.Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SQLiteExecutor {
    private static String dbUrl = "jdbc:sqlite:gym-journal.db";

    public SQLiteExecutor() {
    }
    public SQLiteExecutor(String url) {
        dbUrl = url;
    }

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl);
    }

    public void initDB() {
        File f = new File(System.getProperty("user.dir") + "/" + dbUrl.substring(12));
        if(!f.exists()){
            URL initDbURL = Main.class.getClassLoader().getResource("kcz/initDb.sql");
            executeStatement(initDbURL);
        }
    }

    public void resetDB() {
        File f = new File(System.getProperty("user.dir") + "/" + dbUrl.substring(12));
        if(f.exists()){
            dropDB();
            URL url = Main.class.getClassLoader().getResource("kcz/initDb.sql");
            executeStatement(url);
            url = Main.class.getClassLoader().getResource("kcz/populateDb.sql");
            executeStatement(url);
        }
    }

    private void printMetaData(Connection connection) throws SQLException {
        DatabaseMetaData metaData = connection.getMetaData();
        String format = "\nDatabase metadata\n"
                + "Database name : %s\n"
                + "Database version : %s\n"
                + "Database driver name : %s\n"
                + "Database driver version : %s\n\n";
        System.out.printf(format,
                metaData.getDatabaseProductName(),
                metaData.getDatabaseProductVersion(),
                metaData.getDriverName(),
                metaData.getDriverVersion());
    }

    public void executeSingleStatement(String sqlQuery){
        try(Connection connection = getConnection()) {
            Statement statement = connection.createStatement();
            sqlQuery = sqlQuery.trim();
            statement.execute(sqlQuery);
            System.out.println("Executed SQL query: " + sqlQuery);
        }
        catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void executeStatement(URL sqlFilePath) {
        try(FileReader reader = new FileReader(sqlFilePath.getPath());
            Connection connection = getConnection()) {

            BufferedReader br = new BufferedReader(reader);

            Statement statement = connection.createStatement();
            System.out.println("Executing query: " + sqlFilePath);

            StringBuilder sb = new StringBuilder();
            String line;
            int lineNumber = 0;
            int count = 0;

            // Read lines from the SQL file until the end of the
            // file is reached.
            while ((line = br.readLine()) != null) {
                lineNumber += 1;
                line = line.trim();

                // Skip empty lines and single-line comments.
                if (line.isEmpty() || line.startsWith("--"))
                    continue;

                sb.append(line);
                // If the line ends with a semicolon, it
                // indicates the end of an SQL command.
                if (line.endsWith(";"))
                    try {
                        // Execute the SQL command
                        statement.execute(sb.toString());
                        // Print a success message along with
                        // the first 15 characters of the
                        // executed command.
                        System.out.println(
                                ++count
                                        + " Command successfully executed : "
                                        + sb.substring(
                                        0,
                                        Math.min(sb.length(), 15))
                                        + "...");
                        sb.setLength(0);
                    } catch (SQLException e) {
                        // If an SQLException occurs during
                        // execution, print an error message and
                        // stop further execution.
                        System.err.println(
                                "At line " + lineNumber + " : "
                                        + e.getMessage() + "\n");
                        return;
                    }
            }
        } catch (IOException | SQLException e) {
            System.err.println(e.getMessage());
        }
    }

    public void dropDB() {
        try (Connection connection = getConnection();
             Statement selectStatement = connection.createStatement();
             ResultSet tableSet = selectStatement.executeQuery("SELECT name FROM sqlite_master WHERE type='table'")) {

            List<String> tableNames = new ArrayList<>();

            while (tableSet.next()) {
                String tableName = tableSet.getString("name");
                if (!tableName.startsWith("sqlite_")) {
                    tableNames.add(tableName);
                }
            }

            try (Statement dropStatement = connection.createStatement()) {
                for (String tableName : tableNames) {
                    String query = "DROP TABLE IF EXISTS " + tableName;
                    dropStatement.execute(query);
                    System.out.println("Executed SQL query: " + query);
                }
            }

        } catch (SQLException e) {
            System.err.println("SQL exception: " + e.getMessage());
        }
    }

    public void printDatabase() {
        try (Connection connection = getConnection();
             Statement statement = connection.createStatement();
             ResultSet tables = statement.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name NOT LIKE 'sqlite_%'")) {

            while (tables.next()) {
                String tableName = tables.getString("name");
                System.out.println("\nTable: " + tableName);

                try (Statement tableStatement = connection.createStatement();
                     ResultSet tableData = tableStatement.executeQuery("SELECT * FROM " + tableName)) {

                    ResultSetMetaData metaData = tableData.getMetaData();
                    int columnCount = metaData.getColumnCount();

                    for (int i = 1; i <= columnCount; i++) {
                        System.out.print(metaData.getColumnName(i) + "\t");
                    }
                    System.out.println("\n" + "-------------------------------------------------");

                    while (tableData.next()) {
                        for (int i = 1; i <= columnCount; i++) {
                            System.out.print(tableData.getString(i) + "\t");
                        }
                        System.out.println();
                    }
                } catch (SQLException e) {
                    System.err.println("Select error: " + tableName + ": " + e.getMessage());
                }
            }

        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }
}

