package kcz;

import kcz.repository.utils.SQLiteExecutor;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class SQLiteExecutorTest {
    private static final String initPath = "kcz/initDb.sql";
    private static final String populatePath = "kcz/populateDb.sql";
    private static SQLiteExecutor executor;
    private static final String dbPath = "jdbc:sqlite:test.db";

    @BeforeAll
    static void setUp() {
        executor = new SQLiteExecutor(dbPath);
        URL url = Thread.currentThread().getContextClassLoader().getResource(initPath);
        executor.executeStatement(url);
        url = Thread.currentThread().getContextClassLoader().getResource(populatePath);
        executor.executeStatement(url);
    }

    @AfterAll
    static void clearDb() {
        try {
            File file = new File(dbPath);
            if (file.exists()) {
                file.delete();
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

//    @Test
//    void selectSingleStatementTest() {
//        String query = "select * from exercises";
//        List<Map<String, Object>> resultSet = executor.selectSingleStatement(query);
//        Assertions.assertNotNull(resultSet);
//
//        query = "select count(*) from exercises";
//        resultSet = executor.selectSingleStatement(query);
//        try {
//            resultSet.next();
//            Assertions.assertEquals(3, resultSet.getInt(1));
//        } catch (SQLException e) {
//            throw new RuntimeException(e);
//        }
//    }
}