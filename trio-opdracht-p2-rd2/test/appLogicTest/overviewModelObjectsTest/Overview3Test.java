package appLogicTest.overviewModelObjectsTest;

import appLogic.overviewModelObjects.Overview3;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/** Test class for the Overview3 model object. */
class Overview3Test {
    private Overview3 testOverview3;

    /** Instantiates an Overview3 object to test our getters and setters on. */
    @BeforeEach
    void setUp() {
        testOverview3 = new Overview3("stefanjaspers@hotmail.com", "Stefan", 8002, "Pulp Fiction");
    }

    @Test
    void getEmailWithInputStefanJaspersAtHotmailDotComReturnsStefanJaspersAtHotmailDotCom() {
        // Act
        String result = testOverview3.getEmail();

        // Assert
        Assertions.assertEquals("stefanjaspers@hotmail.com", result);
    }

    @Test
    void setEmailWithInputIzaMoerenhoutAtHotmailDotCom() {
        // Arrange
        testOverview3.setEmail("izamoerenhout@hotmail.com");

        // Act
        String result = testOverview3.getEmail();

        // Assert
        Assertions.assertEquals("izamoerenhout@hotmail.com", result);
    }

    @Test
    void getProfileNameWithInputStefanReturnsStefan() {
        // Act
        String result = testOverview3.getProfileName();

        // Assert
        Assertions.assertEquals("Stefan", result);
    }

    @Test
    void setProfileNameWithInputIza() {
        // Arrange
        testOverview3.setProfileName("Iza");

        // Act
        String result = testOverview3.getProfileName();

        // Assert
        Assertions.assertEquals("Iza", result);
    }

    @Test
    void getProgramIdWithInput8002Returns8002() {
        // Act
        int result = testOverview3.getProgramId();

        // Assert
        Assertions.assertEquals(8002, result);
    }

    @Test
    void setProgramIdWithInput8012() {
        // Arrange
        testOverview3.setProgramId(8002);

        // Act
        int result = testOverview3.getProgramId();

        // Assert
        Assertions.assertEquals(8002, result);
    }

    @Test
    void getMovieNameWithInputPulpFictionReturnsPulpFiction() {
        // Act
        String result = testOverview3.getMovieName();

        // Assert
        Assertions.assertEquals("Pulp Fiction", result);
    }

    @Test
    void setMovieNameWithInputOber() {
        // Arrange
        testOverview3.setMovieName("Ober");

        // Act
        String result = testOverview3.getMovieName();

        // Assert
        Assertions.assertEquals("Ober", result);
    }
}