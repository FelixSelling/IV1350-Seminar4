package se.kth.iv1350.felixselling.mypos.view;

import se.kth.iv1350.felixselling.mypos.model.SaleObserver;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class TotalRevenueFileView implements SaleObserver {
    private Double totalRevenue;
    private PrintWriter logStream;

    /**
     * Creates new instace. Total revenue starts at 0.
     */
    TotalRevenueFileView() {
        totalRevenue = 0.0;
        try {
            logStream = new PrintWriter(new FileWriter("log.txt"), true);
        } catch (IOException ioe) {
            System.out.println("Failed to log.");
            ioe.printStackTrace();
        }
    }

    @Override
    public void onCompleteSale(double revenue) {
        totalRevenue += revenue;
        logStream.println("Total revenue: " + totalRevenue);
    }

}
