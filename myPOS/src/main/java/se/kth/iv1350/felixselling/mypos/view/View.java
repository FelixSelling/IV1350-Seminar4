package se.kth.iv1350.felixselling.mypos.view;

import se.kth.iv1350.felixselling.mypos.controller.Controller;
import se.kth.iv1350.felixselling.mypos.model.dto.ItemDTO;

/**
 * This is a placeholder for the real view. Currently contains system calls to
 * test the flow of operations.
 */
public class View {

    /**
     * Constructor for the view
     * 
     * @param contr Reference to the controller.
     */
    public View(Controller contr) {
        // initiate sale
        System.out.println("\nStart Sale...");
        contr.startSale();
    }

    /**
     * Hard coded code to test system calls from the view.
     * 
     * @param contr Reference to the controller.
     */
    public void testExecution(Controller contr) {
        // scan items
        System.out.println("\nScaning item...");
        printItemDTO(contr.scanItem(12345, 1));
        System.out.println("Running total (inc VAT): " + contr.getRunningTotalIncludingVAT());

        System.out.println("\nScaning item...");
        printItemDTO(contr.scanItem(11111, 1));
        System.out.println("Running total (inc VAT): " + contr.getRunningTotalIncludingVAT());

        System.out.println("\nScaning item...");
        printItemDTO(contr.scanItem(54321, 1));
        System.out.println("Running total (inc VAT): " + contr.getRunningTotalIncludingVAT());

        System.out.println("\nScaning item...");
        printItemDTO(contr.scanItem(11111, 1));
        System.out.println("Running total (inc VAT): " + contr.getRunningTotalIncludingVAT());

        // end sale
        contr.endsale();
        System.out.println("\nTotal price (inc VAT): " + contr.getRunningTotalIncludingVAT());

        // register payment
        contr.pay(10000);

        // finalize sale
        contr.finalizeSale();

        // present change to give to customer
        System.out.println("\nChange: " + contr.getChange());
    }

    private void printItemDTO(ItemDTO item) {
        System.out.println("Description: " + item.getDescription());
        System.out.println("Price: " + item.getPrice());
        System.out.println("VAT Rate: " + item.getVatRate() + "%");
    }
}


