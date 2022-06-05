package se.kth.iv1350.felixselling.mypos.model;

import java.time.LocalDateTime;
import se.kth.iv1350.felixselling.mypos.model.dto.ItemDTO;

/**
 * Sale class for handling and storing information of a sale.
 */
public class Sale {
    private final LocalDateTime dateTimeOfSale;
    private ItemDTO[] itemDTOList;
    private int[] itemQuantityList;
    private Receipt receipt;

    public CashPayment cashPayment;

    /**
     * Constructor. Saves the time and date of creation
     */
    public Sale() {
        dateTimeOfSale = LocalDateTime.now();
    }

    /**
     * Method to add item to the sale.
     * 
     * @param item     The item to add.
     * @param quantity The quantity of the item to add.
     */
    public void addItem(ItemDTO item, int quantity) {
        if (itemDTOList == null) {
            ItemDTO[] tempItemDTOList = { item };
            int[] tempItemQuantityList = { quantity };
            itemDTOList = tempItemDTOList;
            itemQuantityList = tempItemQuantityList;

        } else if (checkIfItemExistInList(item)) {
            for (int itemRow = 0; itemRow < itemDTOList.length; itemRow++) {
                if (itemDTOList[itemRow].getItemIdentifier() == item.getItemIdentifier()) {
                    itemQuantityList[itemRow] += quantity;
                    break;
                }
            }
        } else {
            ItemDTO[] tempItemDTOList = new ItemDTO[itemDTOList.length + 1];
            int[] tempItemQuantityList = new int[itemQuantityList.length + 1];

            for (int itemRow = 0; itemRow < itemDTOList.length; itemRow++) {
                tempItemDTOList[itemRow] = itemDTOList[itemRow];
                tempItemQuantityList[itemRow] = itemQuantityList[itemRow];
            }

            tempItemDTOList[tempItemDTOList.length - 1] = item;
            tempItemQuantityList[tempItemQuantityList.length - 1] = quantity;

            itemDTOList = tempItemDTOList;
            itemQuantityList = tempItemQuantityList;
        }

    }

    // private method to check if item exist in list.
    private boolean checkIfItemExistInList(ItemDTO item) {
        if (itemDTOList != null) {
            for (int itemRow = 0; itemRow < itemDTOList.length; itemRow++) {
                if (itemDTOList[itemRow].getItemIdentifier() == item.getItemIdentifier())
                    return true;
            }
        }
        return false;
    }

    /**
     * Method that calculates the running total including tax of the sale.
     * 
     * @return The running total including tax of the sale.
     */
    public double getRunningTotalIncludingVAT() {
        double totalSum = 0;
        if (itemDTOList != null) {
            for (int itemRow = 0; itemRow < itemDTOList.length; itemRow++) {
                totalSum += (itemDTOList[itemRow].getPrice() * itemQuantityList[itemRow])
                        * (1 + (itemDTOList[itemRow].getVatRate() / 100));
            }
        }
        return totalSum;
    }

    /**
     * Method that prepares the sale for payment
     */
    public void endSale() {
        cashPayment = new CashPayment(getRunningTotalIncludingVAT());
    }

    /**
     * Method to complete the sale. Calls to create the receipt for the sale.
     */
    public void completeSale() {
        createReceipt();
    }

    private void createReceipt() {
        receipt = new Receipt(dateTimeOfSale, itemDTOList, itemQuantityList, cashPayment);
    }

    /**
     * Get method.
     * 
     * @return The sales receipt.
     */
    public Receipt getReceipt() {
        return receipt;
    }
}
