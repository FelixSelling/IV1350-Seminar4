package se.kth.iv1350.felixselling.mypos.model.dto;

/**
 * Item data transfer object. Used for transfering item information between
 * packages.
 */
public class ItemDTO {
    private final int itemIdentifier;
    private final double price, vatRate;
    private final String description;

    /**
     * Constructor for ItemDTO.
     * 
     * @param itemIdentifier The unique identifier for each item.
     * @param price          The price before tax for the item.
     * @param vatRate        The tax rate for the item.
     * @param description    Description of the item.
     */
    public ItemDTO(int itemIdentifier, double price, double vatRate, String description) {
        this.itemIdentifier = itemIdentifier;
        this.price = price;
        this.vatRate = vatRate;
        this.description = description;
    }

    /**
     * Get method.
     * 
     * @return The items unique identifier.
     */
    public int getItemIdentifier() {
        return itemIdentifier;
    }

    /**
     * Get method.
     * 
     * @return The items price before tax.
     */
    public double getPrice() {
        return price;
    }

    /**
     * Get method.
     * 
     * @return The tax rate for the item.
     */
    public double getVatRate() {
        return vatRate;
    }

    /**
     * Get method.
     * 
     * @return The description of the item.
     */
    public String getDescription() {
        return description;
    }

}
