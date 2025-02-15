package kcz;

import kcz.model.User;
import kcz.repository.utils.SQLiteExecutor;
import kcz.repository.UserDao;
import org.junit.jupiter.api.*;

import java.io.File;
import java.net.URL;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class UserDaoTest {
    private static final String TEST_DB_URL = "jdbc:sqlite:test.db";
    private static final String initPath = "kcz/initDb.sql";
    private static final String populatePath = "kcz/populateDb.sql";
    private static UserDao userDao;

    @BeforeAll
    static void setup() {
        userDao = new UserDao();
        userDao.setDbUrl(TEST_DB_URL);

        SQLiteExecutor executor = new SQLiteExecutor(TEST_DB_URL);

        URL url = UserDaoTest.class.getClassLoader().getResource(initPath);
        executor.executeStatement(url);
        url = UserDaoTest.class.getClassLoader().getResource(populatePath);
        executor.executeStatement(url);
    }

    @AfterAll
    static void tearDown() {
        // 🔹 Usuwanie pliku testowej bazy danych
        File file = new File("test.db");
        if (file.exists() && !file.delete()) {
            System.err.println("Cannot delete test.db");
        }
    }

    @Test
    void testAddUser() {
        User user = new User();
        user.setUsername("testUser");

        userDao.addUser(user);

        List<User> users = userDao.getUsers();
        assertEquals(3, users.size());
        assertEquals("testUser", users.get(2).getUsername());
    }

    @Test
    void testGetUser() {
        User user = new User();
        user.setUsername("anotherUser");

        userDao.addUser(user);
        int userId = userDao.getUsers().size();

        User fetchedUser = userDao.getUser(userId);
        assertNotNull(fetchedUser);
        assertEquals("anotherUser", fetchedUser.getUsername());

        fetchedUser = userDao.getUser("anotherUser");
        assertNotNull(fetchedUser);
        assertEquals("anotherUser", fetchedUser.getUsername());
    }

    @Test
    void testGetUser_NotExists() {
        User user = userDao.getUser(999);
        assertNull(user, "Fetching non-existent user should return null");
    }
}
