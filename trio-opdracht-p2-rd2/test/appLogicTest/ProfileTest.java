package appLogicTest;

import appLogic.Profile;
import org.junit.jupiter.api.*;

/** Test class for the Profile model object. */
class ProfileTest {
    private Profile testProfile;

    /** Instantiates a Profile object to test our getters and setters on. */
    @BeforeEach
    void setUp() {
        testProfile = new Profile("stefanjaspers@hotmail.com", "Stefan Jaspers", "Stefan", 22);
    }

    @Test
    void testGetEmailWithInputStefanJaspersAtHotmailDotComReturnsStefanJaspersAtHotmailDotCom() {
        // Act
        String result = testProfile.getEmail();

        // Assert
        Assertions.assertEquals("stefanjaspers@hotmail.com", result);
    }

    @Test
    void testSetEmailWithInputIzaMoerenhout() {
        // Arrange
        testProfile.setEmail("izamoerenhout@hotmail.com");

        // Act
        String result = testProfile.getEmail();

        // Assert
        Assertions.assertEquals("izamoerenhout@hotmail.com", result);
    }

    @Test
    void testGetAccountNameWithInputStefanJaspersReturnsStefanJaspers() {
        // Act
        String result = testProfile.getAccountName();

        // Assert
        Assertions.assertEquals("Stefan Jaspers", result);
    }

    @Test
    void testSetAccountNameWithInputIzaMoerenhout() {
        // Arrange
        testProfile.setAccountName("Iza Moerenhout");

        // Act
        String result = testProfile.getAccountName();

        // Assert
        Assertions.assertEquals("Iza Moerenhout", result);
    }

    @Test
    void testGetProfileNameWithInputStefanReturnsStefan() {
        // Act
        String result = testProfile.getProfileName();

        // Assert
        Assertions.assertEquals("Stefan", result);
    }

    @Test
    void testSetProfileNameWithInputIza() {
        // Arrange
        testProfile.setProfileName("Iza");

        // Act
        String result = testProfile.getProfileName();

        // Assert
        Assertions.assertEquals("Iza", result);
    }

    @Test
    void testGetAgeWithInput22Returns22() {
        // Act
        int result = testProfile.getAge();

        // Assert
        Assertions.assertEquals(22, result);
    }

    @Test
    void testSetAgeWithInput19() {
        // Arrange
        testProfile.setAge(19);

        // Act
        int result = testProfile.getAge();

        // Assert
        Assertions.assertEquals(19, result);
    }
}
