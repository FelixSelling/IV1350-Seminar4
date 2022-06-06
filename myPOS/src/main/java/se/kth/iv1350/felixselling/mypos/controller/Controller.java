package se.kth.iv1350.felixselling.mypos.controller;

import java.util.ArrayList;
import java.util.List;

import se.kth.iv1350.felixselling.mypos.integration.*;
import se.kth.iv1350.felixselling.mypos.model.Sale;
import se.kth.iv1350.felixselling.mypos.model.SaleObserver;
import se.kth.iv1350.felixselling.mypos.model.dto.ItemDTO;

/**
 * The applications controller. All systemcalls from view passes through
 * controller.
 */
public class Controller {
    private Sale currentSale;
    private ArrayList<Sale> saleLog = new ArrayList<>();
    private AccountingSystem accountingSystem;
    private InventorySystem inventorySystem;
    private CashRegister cashRegister;
    private ItemRegister itemRegister;
    private Printer printer;
    private List<SaleObserver> saleObservers = new ArrayList<>();

    /**
     * Constructor for Controller
     */
    public Controller() {
        accountingSystem = new AccountingSystem();
        inventorySystem = new InventorySystem();
        cashRegister = new CashRegister();
        itemRegister = new ItemRegister();
        printer = new Printer();
    }

    /**
     * Methods that initiates the sale. This need to be called one time before any
     * sale-manipulating method.
     */
    public void startSale() {
        currentSale = new Sale();
        currentSale.addSaleObservers(saleObservers);
    }

    /**
     * @param itemIdentifier The unique id for the item that will connect it with
     *                       the correct item in the database
     * @param quantity       Amount of the item currently scanned
     * @return Information on the item retrieved from external database.
     * @throws ScanItemFailedException Thrown if method encounters exception that
     *                                 stops the method from doing its task.
     */
    public ItemDTO scanItem(int itemIdentifier, int quantity) throws ScanItemFailedException {

        ItemDTO item = null;
        try {
            item = itemRegister.getItemData(itemIdentifier);
            currentSale.addItem(item, quantity);
        } catch (ItemNotFoundException itemNotFoundExeption) {
            throw new ScanItemFailedException("Item with ItemID "
                    + itemNotFoundExeption.getItemIdentifierForItemNotFound() + " could not be found.");
        } catch (DatabaseConnectionFailureException databaseConnectionFailureException) {
            throw new ScanItemFailedException(
                    "Could not connect to database, please check internet connection of POS-station.");
        }
        return item;
    }

    /**
     * Method that tells the current sale to conclude the sale and prepare for
     * payment
     */
    public void endsale() {
        currentSale.endSale();
    }

    /**
     * @return The running total on the current sale.
     */
    public double getRunningTotalIncludingVAT() {
        return currentSale.getRunningTotalIncludingVAT();
    }

    /**
     * @param cashAmount The amount of cash the customer paid with.
     * @return double
     */
    public double pay(double cashAmount) {
        cashRegister.addCash(cashAmount);
        currentSale.cashPayment.registerPayment(cashAmount);
        return currentSale.cashPayment.getChange();
    }

    /**
     * Method that after payment is done finalizes the sale with logging of sale,
     * sending information to external systems and prints the receipt.
     */
    public void finalizeSale() {
        currentSale.completeSale();
        cashRegister.removeCash(currentSale.cashPayment.getChange());
        accountingSystem.sendSaleInformation(currentSale);
        inventorySystem.sendSaleInformation(currentSale);
        printer.printReceipt(currentSale.getReceipt());
        saleLog.add(currentSale);
    }

    /**
     * @return The amount of change the customer shall receive.
     */
    public double getChange() {
        return currentSale.cashPayment.getChange();
    }

    public void addSaleObserver(SaleObserver obs) {
        saleObservers.add(obs);
    }
}
