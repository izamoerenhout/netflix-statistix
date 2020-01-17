package appLogicTest.overviewModelObjectsTest;

import appLogic.overviewModelObjects.Overview2;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for the Overview2 model object. */
class Overview2Test {
    private Overview2 testOverview2;

    /** Instantiates an Overview2 object to test our getters and setters on. */
    @BeforeEach
    void setUp() {
        testOverview2 = new Overview2("stefanjaspers@hotmail.com", 2000, "S01E01","Pilot", 56);
    }

    @Test
    void getEmailWithInputStefanJaspersAtHotmailDotComReturnsStefanJaspersAtHotmailDotCom() {
        // Act
        String result = testOverview2.getEmail();

        // Assert
        Assertions.assertEquals("stefanjaspers@hotmail.com", result);
    }

    @Test
    void setEmailWithInputIzaMoerenhoutAtHotmailDotCom() {
        // Arrange
        testOverview2.setEmail("izamoerenhout@hotmail.com");

        // Act
        String result = testOverview2.getEmail();

        // Assert
        Assertions.assertEquals("izamoerenhout@hotmail.com", result);
    }

    @Test
    void getProgramIdWithInput2000Returns2000() {
        // Act
        int result = testOverview2.getProgramId();

        // Assert
        Assertions.assertEquals(2000, result);
    }

    @Test
    void setProgramIdWithInput2001() {
        // Arrange
        testOverview2.setProgramId(2001);

        // Act
        int result = testOverview2.getProgramId();

        // Assert
        Assertions.assertEquals(2001, result);
    }

    @Test
    void getEpisodeNrWithInputS01E01ReturnsS01E01() {
        // Act
        String result = testOverview2.getEpisodeNr();

        // Assert
        Assertions.assertEquals("S01E01", result);
    }

    @Test
    void setEpisodeNrWithInputS01E02() {
        // Arrange
        testOverview2.setEpisodeNr("S01E02");

        // Act
        String result = testOverview2.getEpisodeNr();

        // Assert
        Assertions.assertEquals("S01E02", result);
    }

    @Test
    void getEpisodeNameWithInputPilotReturnsPilot() {
        // Act
        String result = testOverview2.getEpisodeName();

        // Assert
        Assertions.assertEquals("Pilot", result);
    }

    @Test
    void setEpisodeNameWithInputCatsInTheBag() {
        // Arrange
        testOverview2.setEpisodeName("Cat's In The Bag");

        // Act
        String result = testOverview2.getEpisodeName();

        // Assert
        Assertions.assertEquals("Cat's In The Bag", result);
    }

    @Test
    void getAvgPctWatchedWithInput56Returns56() {
        // Act
        int result = testOverview2.getAvgPctWatched();

        // Assert
        Assertions.assertEquals(56, result);
    }

    @Test
    void setAvgPctWatchedWithInput100() {
        // Arrange
        testOverview2.setAvgPctWatched(100);

        // Act
        int result = testOverview2.getAvgPctWatched();

        // Assert
        Assertions.assertEquals(100, result);
    }

    @Test
    void setAvgPctWatchedWithInputAbove100ReturnsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testOverview2.setAvgPctWatched(105));

        String expectedMessage = "Average percentage watched should be between 0 and 100.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setAvgPctWatchedWithNegativeInputReturnsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testOverview2.setAvgPctWatched(-5));

        String expectedMessage = "Average percentage watched should be between 0 and 100.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}