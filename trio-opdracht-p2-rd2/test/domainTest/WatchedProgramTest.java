package domainTest;

import domain.WatchedProgram;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for the WatchedProgram model object. */
class WatchedProgramTest {
    private WatchedProgram testWatchedProgram;

    /** Instantiates a WatchedProgram object to test our getters and setters on. */
    @BeforeEach
    void setUp() {
        testWatchedProgram = new WatchedProgram("stefanjaspers@hotmail.com", "Stefan Jaspers", "Stefan",
                2001, 90);
    }

    @Test
    void getEmailWithInputStefanJaspersAtHotmailDotComReturnsStefanJaspersAtHotmailDotCom() {
        // Act
        String result = testWatchedProgram.getEmail();

        // Assert
        Assertions.assertEquals("stefanjaspers@hotmail.com", result);
    }

    @Test
    void setEmailWithInputIzaMoerenhoutAtHotmailDotCom() {
        // Arrange
        testWatchedProgram.setEmail("izamoerenhout@hotmail.com");

        // Act
        String result = testWatchedProgram.getEmail();

        // Assert
        Assertions.assertEquals("izamoerenhout@hotmail.com", result);
    }

    @Test
    void getAccountNameWithInputStefanJaspersReturnsStefanJaspers() {
        // Act
        String result = testWatchedProgram.getAccountName();

        // Assert
        Assertions.assertEquals("Stefan Jaspers", result);
    }

    @Test
    void setAccountNameWithInputIzaMoerenhout() {
        // Arrange
        testWatchedProgram.setAccountName("Iza Moerenhout");

        // Act
        String result = testWatchedProgram.getAccountName();

        // Assert
        Assertions.assertEquals("Iza Moerenhout", result);
    }

    @Test
    void getProfileNameWithInputStefanReturnsStefan() {
        // Act
        String result = testWatchedProgram.getProfileName();

        // Assert
        Assertions.assertEquals("Stefan", result);
    }

    @Test
    void setProfileNameWithInputIza() {
        // Arrange
        testWatchedProgram.setProfileName("Iza");

        // Act
        String result = testWatchedProgram.getProfileName();

        // Assert
        Assertions.assertEquals("Iza", result);
    }

    @Test
    void getProgramIdWithInput2001Returns2001() {
        // Act
        int result = testWatchedProgram.getProgramId();

        // Assert
        Assertions.assertEquals(2001, result);
    }

    @Test
    void setProgramIdWithInput2005() {
        // Arrange
        testWatchedProgram.setProgramId(2005);

        // Act
        int result = testWatchedProgram.getProgramId();

        // Assert
        Assertions.assertEquals(2005, result);
    }

    @Test
    void getPctWatchedWithInput90Returns90() {
        // Act
        int result = testWatchedProgram.getPctWatched();

        // Assert
        Assertions.assertEquals(90, result);
    }

    @Test
    void setPctWatchedWithInput100() {
        // Arrange
        testWatchedProgram.setPctWatched(100);

        // Act
        int result = testWatchedProgram.getPctWatched();

        // Assert
        Assertions.assertEquals(100, result);
    }

    @Test
    void setPctWatchedWithInputAbove100ReturnsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testWatchedProgram.setPctWatched(105));

        String expectedMessage = "Percentage watched should be between 0 and 100.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    @Test
    void setPctWatchedWithNegativeInputReturnsIllegalArgumentException() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> testWatchedProgram.setPctWatched(-5));

        String expectedMessage = "Percentage watched should be between 0 and 100.";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }
}