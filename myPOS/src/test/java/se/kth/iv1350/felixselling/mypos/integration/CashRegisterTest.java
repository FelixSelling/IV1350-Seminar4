package se.kth.iv1350.felixselling.mypos.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashRegisterTest {

    private CashRegister cashRegisterWithInitial5000;

    @BeforeEach
    public void setUp() {
        cashRegisterWithInitial5000 = new CashRegister(5000);
    }

    @AfterEach
    public void tearDown() {
        cashRegisterWithInitial5000 = null;
    }

    @Test
    public void testAddCash() {
        double expected = 5000 + 1000;
        cashRegisterWithInitial5000.addCash(1000);
        double actual = cashRegisterWithInitial5000.getCash();
        assertEquals(expected, actual, "CashRegisters cash balance and expected cash balance not equal.");
    }

    @Test
    public void testRemoveCash() {

        double expected = 5000 - 1000;
        cashRegisterWithInitial5000.removeCash(1000);
        double actual = cashRegisterWithInitial5000.getCash();
        assertEquals(expected, actual, "CashRegisters cash balance and expected cash balance not equal.");
    }
}
