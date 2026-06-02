package util;

public class ReportGenerator {

    public static void generateReport(int orders, int inventoryItems, String status) {
        System.out.println("\n========== SYSTEM REPORT ==========");
        System.out.println("Orders Processed : " + orders);
        System.out.println("Inventory Items  : " + inventoryItems);
        System.out.println("System Status    : " + status);
        System.out.println("===================================\n");
    }
}
