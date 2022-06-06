package se.kth.iv1350.felixselling.mypos.view;

import se.kth.iv1350.felixselling.mypos.model.SaleObserver;

public class TotalRevenueView implements SaleObserver {
    private Double totalRevenue;

    /**
     * Creates a new instance. Total revenue starts at 0.
     */
    TotalRevenueView() {
        totalRevenue = 0.0;
    }

    @Override
    public void onCompleteSale(double revenue) {
        totalRevenue += revenue;
        System.out.println("\nObserver--> Total revenue: " + totalRevenue);
    }

}
