package databaseTest.daoTest;

import database.DatabaseConnector;
import database.dao.WatchedProgramDAO;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for the WatchedProgram Data Access Object. */
class WatchedProgramDAOTest {
    private WatchedProgramDAO testDAO;

    /** Instantiates a WatchedProgramDAO object and inserts a new watched program to test our update methods on.
     * programId 1 and 2 are test programs in the database, dedicated specifically to unit testing. */
    @BeforeEach
    void setUp() {
        testDAO = new WatchedProgramDAO(new DatabaseConnector());
        testDAO.insertWatchedProgram("s.jaspers1997@gmail.com", "Stefan", 1, 100);
    }

    /** Deletes the watched program after testing. */
    @AfterEach
    void tearDown() {
        testDAO.deleteWatchedProgram("s.jaspers1997@gmail.com", "Stefan", 1);
        testDAO.deleteWatchedProgram("s.jaspers1997@gmail.com", "Stefan", 2);
    }

    @Test
    void updateWatchedProgramPctWatchedWithPercentageAbove100ReturnsFalse() {
        // Act
        boolean successful = testDAO.updateWatchedProgramPctWatched(101, 1, "s.jaspers1997@gmail.com", "Stefan");

        // Assert
        Assertions.assertFalse(successful);
    }

    @Test
    void updateWatchedProgramPctWatchedWithNegativePercentageReturnsFalse() {
        // Act
        boolean successful = testDAO.updateWatchedProgramPctWatched(-1, 1, "s.jaspers1997@gmail.com", "Stefan");

        // Assert
        Assertions.assertFalse(successful);
    }

    @Test
    void insertWatchedProgramWithPctWatchedAbove100ReturnsFalse() {
        // Act
        boolean successful = testDAO.insertWatchedProgram("s.jaspers1997@gmail.com", "Stefan", 2, 101);

        // Assert
        Assertions.assertFalse(successful);
    }

    @Test
    void insertWatchedProgramWithNegativePctWatchedReturnsFalse() {
        // Act
        boolean successful = testDAO.insertWatchedProgram("s.jaspers1997@gmail.com", "Stefan", 2, -1);

        // Assert
        Assertions.assertFalse(successful);
    }
}