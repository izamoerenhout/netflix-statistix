package appLogic.overviewModelObjects;

import appLogic.Account;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for the Overview1 model object. */
class Overview1Test {
    private Overview1 testOverview1;

    /** Instantiates an Overview1 object to test our getters and setters on. */
    @BeforeEach
    void setUp() {
        testOverview1 = new Overview1(2000, "S01E01", "Pilot", 56);
    }

    @Test
    void getProgramIdWithInput2000Returns2000() {
        // Act
        int result = testOverview1.getProgramId();

        // Assert
        Assertions.assertEquals(2000, result);
    }

    @Test
    void setProgramIdWithInput2001() {
        // Arrange
        testOverview1.setProgramId(2001);

        // Act
        int result = testOverview1.getProgramId();

        // Assert
        Assertions.assertEquals(2001, result);
    }

    @Test
    void getEpisodeNrWithInputS01E01ReturnsS01E01() {
        // Act
        String result = testOverview1.getEpisodeNr();

        // Assert
        Assertions.assertEquals("S01E01", result);
    }

    @Test
    void setEpisodeNrWithInputS01E02() {
        // Arrange
        testOverview1.setEpisodeNr("S01E02");

        // Act
        String result = testOverview1.getEpisodeNr();

        // Assert
        Assertions.assertEquals("S01E02", result);
    }

    @Test
    void getEpisodeNameWithInputPilotReturnsPilot() {
        // Act
        String result = testOverview1.getEpisodeName();

        // Assert
        Assertions.assertEquals("Pilot", result);
    }

    @Test
    void setEpisodeNameWithInputCatsInTheBag() {
        // Arrange
        testOverview1.setEpisodeName("Cat's In The Bag");

        // Act
        String result = testOverview1.getEpisodeName();

        // Assert
        Assertions.assertEquals("Cat's In The Bag", result);
    }

    @Test
    void getAvgPctWatchedWithInput56Returns56() {
        // Act
        int result = testOverview1.getAvgPctWatched();

        // Assert
        Assertions.assertEquals(56, result);
    }

    @Test
    void setAvgPctWatchedWithInput100() {
        // Arrange
        testOverview1.setAvgPctWatched(100);

        // Act
        int result = testOverview1.getAvgPctWatched();

        // Assert
        Assertions.assertEquals(100, result);
    }

    @Test
    void setAvgPctWatchedWithInputAbove100ReturnsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testOverview1.setAvgPctWatched(105));

        String expectedMessage = "Average percentage watched has to be between 0 and 100.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setAvgPctWatchedWithNegativeInputReturnsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testOverview1.setAvgPctWatched(-5));

        String expectedMessage = "Average percentage watched has to be between 0 and 100.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}