package appLogicTest;

import appLogic.Account;
import org.junit.jupiter.api.*;

class AccountTest {
    private Account testAccount;

    /** Instantiates an Account object to test our getters and setters on. */
    @BeforeEach
    void setUp() {
        testAccount = new Account("stefanjaspers@hotmail.com", "Stefan Jaspers",
                "St. Bernardusstraat 11A", "Hoeven");
    }

    @Test
    void testGetEmailWithInputStefanJaspersAtHotmailDotComReturnsStefanJaspersAtHotmailDotCom () {
        // Act
        String result = testAccount.getEmail();

        // Assert
        Assertions.assertEquals("stefanjaspers@hotmail.com", result);
    }

    @Test
    void testSetEmailWithInputIzaMoerenhoutAtHotmailDotCom() {
        // Arrange
        testAccount.setEmail("izamoerenhout@hotmail.com");

        // Act
        String result = testAccount.getEmail();

        // Assert
        Assertions.assertEquals("izamoerenhout@hotmail.com", result);
    }

    @Test
    void testGetNameWithInputStefanJaspersReturnsStefanJaspers() {
        // Act
        String result = testAccount.getName();

        // Assert
        Assertions.assertEquals("Stefan Jaspers", result);
    }

    @Test
    void testSetNameWithInputIzaMoerenhout() {
        // Arrange
        testAccount.setName("Iza Moerenhout");

        // Act
        String result = testAccount.getName();

        // Assert
        Assertions.assertEquals("Iza Moerenhout", result);
    }

    @Test
    void testGetAddressWithInputStBernardusstraat11AReturnsStBernardusstraat11A() {
        // Act
        String result = testAccount.getAddress();

        // Assert
        Assertions.assertEquals("St. Bernardusstraat 11A", result);
    }

    @Test
    void testSetAddressWithInputMolendijk111() {
        // Arrange
        testAccount.setAddress("Molendijk 111");

        // Act
        String result = testAccount.getAddress();

        // Assert
        Assertions.assertEquals("Molendijk 111", result);
    }

    @Test
    void testGetCityWithInputHoevenReturnsHoeven() {
        // Act
        String result = testAccount.getCity();

        // Assert
        Assertions.assertEquals("Hoeven", result);
    }

    @Test
    void testSetCityWithInputDinteloord() {
        // Arrange
        testAccount.setCity("Dinteloord");

        // Act
        String result = testAccount.getCity();

        // Assert
        Assertions.assertEquals("Dinteloord", result);
    }
}