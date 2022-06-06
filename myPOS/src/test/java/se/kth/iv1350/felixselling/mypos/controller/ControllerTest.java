package se.kth.iv1350.felixselling.mypos.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ControllerTest {

    private Controller controller;

    @BeforeEach
    public void setUp() {
        controller = new Controller();
    }

    @AfterEach
    public void tearDown() {
        controller = null;
    }

    @Test
    public void scanItemDatabaseConnectionFailureExceptionTest() {
        controller.startSale();

        int itemIdentifierToTest = 99999;
        try {
            controller.scanItem(itemIdentifierToTest, 1);
        } catch (ScanItemFailedException scanItemFailedException) {
            assertTrue(scanItemFailedException.getMessage().contains("Could not connect to database"),
                    "Wrong exception message.");

        }
    }

    @Test
    public void scanItemNotFoundExceptionTest() {
        int itemIdentifierToTest = 123456789;
        try {
            controller.scanItem(itemIdentifierToTest, 1);
        } catch (ScanItemFailedException scanItemFailedException) {
            assertTrue(scanItemFailedException.getMessage().contains("Item with ItemID"),
                    "Wrong exception message.");
        }
    }

}
