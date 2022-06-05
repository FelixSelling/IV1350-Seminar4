package se.kth.iv1350.felixselling.mypos.integration;

public class CashRegister {
    private double cash;

    /**
     * Constructor for CashRegister
     */
    public CashRegister() {
        cash = 0;
    }

    /**
     * Constructor for CashRegister
     * 
     * @param cash Initial cash balance of cash register.
     */
    public CashRegister(double cash) {
        this.cash = cash;
    }

    /**
     * Get method.
     * 
     * @return The cash balance of cash register.
     */
    public double getCash() {
        return cash;
    }

    /**
     * Method that adds cash to the register.
     * 
     * @param cash The amount of cash to add.
     */
    public void addCash(double cash) {
        this.cash += cash;
    }

    /**
     * Method that removes cash from the register.
     * 
     * @param cash The amount of cash to remove.
     */
    public void removeCash(double cash) {
        this.cash -= cash;
    }

}
