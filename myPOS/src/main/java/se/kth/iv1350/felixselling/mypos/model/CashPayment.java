package se.kth.iv1350.felixselling.mypos.model;

/**
 * Class that handles the cash payment.
 */
public class CashPayment {
    private double totalIncVat;
    private double cashPaid;

    /**
     * Constructor for CashPayment.
     * 
     * @param totalIncVat The total price to pay including tax.
     */
    public CashPayment(double totalIncVat) {
        this.totalIncVat = totalIncVat;
        this.cashPaid = 0;
    }

    /**
     * Getter method.
     * 
     * @return Total price incuding VAT of instace.
     */
    public double getTotalIncVat() {
        return totalIncVat;
    }

    /**
     * Getter method.
     * 
     * @return Cash paid in instance.
     */
    public double getCashPaid() {
        return cashPaid;
    }

    /**
     * Method to register new payment.
     * 
     * @param cashAmount The amount of cash that was paid.
     */
    public void registerPayment(double cashAmount) {
        cashPaid += cashAmount;
    }

    /**
     * Method that calculates the change
     * 
     * @return the amount of change.
     */
    public double getChange() {
        if ((cashPaid - totalIncVat) < 0)
            return 0;
        return cashPaid - totalIncVat;
    }
}
