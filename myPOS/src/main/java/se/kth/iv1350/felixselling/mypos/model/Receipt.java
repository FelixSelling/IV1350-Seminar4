package se.kth.iv1350.felixselling.mypos.model;

import java.time.LocalDateTime;
import se.kth.iv1350.felixselling.mypos.model.dto.ItemDTO;


/**
 * Class for receipt.
 */
public class Receipt {
    private final LocalDateTime dateTimeOfSale;
    private final ItemDTO[] itemDTOList;
    private final int[] itemQuantityList;
    private final CashPayment cashPayment;

    /**
     * Constructor for receipt.
     * 
     * @param dateTimeOfSale   The time and date of the sale.
     * @param itemDTOList      The items in the transaction contained in an array .
     * @param itemQuantityList The quantity of each item contained in an array.
     * @param cashPayment      The payment
     */
    public Receipt(LocalDateTime dateTimeOfSale, ItemDTO[] itemDTOList, int[] itemQuantityList,
            CashPayment cashPayment) {
        this.dateTimeOfSale = dateTimeOfSale;
        this.itemDTOList = itemDTOList;
        this.itemQuantityList = itemQuantityList;
        this.cashPayment = cashPayment;
    }

    /**
     * Get method.
     * 
     * @return The date and time of the sale
     */
    public LocalDateTime getDateTimeOfSale() {
        return dateTimeOfSale;
    }

    /**
     * Get method.
     * 
     * @return The itemlist of the sale.
     */
    public ItemDTO[] getItemDTOList() {
        return itemDTOList;
    }

    /**
     * Get method.
     * 
     * @return The quantity of item list.
     */
    public int[] getItemQuantityList() {
        return itemQuantityList;
    }

    /**
     * Get method.
     * 
     * @return The cash payment.
     */
    public CashPayment getCashPayment() {
        return cashPayment;
    }

}