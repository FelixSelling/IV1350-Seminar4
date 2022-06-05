package se.kth.iv1350.felixselling.mypos.startup;

import se.kth.iv1350.felixselling.mypos.controller.Controller;
import se.kth.iv1350.felixselling.mypos.view.View;

/**
 * Package startup contains the main method used to start the application.
 */

public class Main {
    public static void main(String[] args) {
        Controller contr = new Controller();
        View view = new View(contr);
        view.testExecution(contr);
    }
}
