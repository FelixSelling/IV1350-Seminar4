package se.kth.iv1350.felixselling.mypos.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CashPaymentTest {

    private CashPayment cashPaymentOf5000;

    @BeforeEach
    public void setUp() {
        cashPaymentOf5000 = new CashPayment(5000);
    }

    @AfterEach
    public void tearDown() {
        cashPaymentOf5000 = null;
    }

    @Test
    public void testRegisterPayment() {
        double expected = 1000;
        cashPaymentOf5000.registerPayment(1000);
        double actual = cashPaymentOf5000.getCashPaid();
        assertEquals(expected, actual, "Expected registered payment and actual payment not equal.");
    }

    @Test
    public void testGetChange() {
        double expected = 6000 - 5000;
        cashPaymentOf5000.registerPayment(6000);
        double actual = cashPaymentOf5000.getChange();
        assertEquals(expected, actual, "Expected change and actual change not equal.");
    }
}
