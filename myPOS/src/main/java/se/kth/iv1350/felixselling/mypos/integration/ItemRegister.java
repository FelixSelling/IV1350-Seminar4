package se.kth.iv1350.felixselling.mypos.integration;

import se.kth.iv1350.felixselling.mypos.model.dto.ItemDTO;

public class ItemRegister {
    /**
     * Constructor for ItemRegister
     */
    public ItemRegister() {
    }

    /**
     * Method not implemented. Should collect information on the item from external
     * item register. Now contains hard coded examples.
     * 
     * @param itemIdentifier The unique identifier for the item.
     * @return The item if found else return null
     */
    public ItemDTO getItemData(int itemIdentifier) {
        switch (itemIdentifier) {
            case 12345:
                return new ItemDTO(12345, 1000, 25, "Keyboard");
            case 54321:
                return new ItemDTO(54321, 5000, 25, "4k display");
            case 11111:
                return new ItemDTO(11111, 25, 12, "Energy drink");
        }
        return null;
    }
}
