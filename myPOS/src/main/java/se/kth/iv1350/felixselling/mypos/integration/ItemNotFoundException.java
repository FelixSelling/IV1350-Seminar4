package se.kth.iv1350.felixselling.mypos.integration;

import java.time.LocalDateTime;

/**
 * Thrown when item is not found in the external database.
 */
public class ItemNotFoundException extends Exception {
    private int itemIdentifierForItemNotFound;

    public ItemNotFoundException(int itemIdentifierForItemNotFound) {
        super("Could not find item with identifier: " + itemIdentifierForItemNotFound);
        this.itemIdentifierForItemNotFound = itemIdentifierForItemNotFound;
        System.out.println("LOG: " + LocalDateTime.now() + " Could not find item in database with itemID="
                + itemIdentifierForItemNotFound);
    }

    public int getItemIdentifierForItemNotFound() {
        return itemIdentifierForItemNotFound;
    }
}
