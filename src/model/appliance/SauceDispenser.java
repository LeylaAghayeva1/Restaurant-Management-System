package model.appliance;
import model.menu.MenuItem;
public class SauceDispenser implements IAppliance {
    @Override
    public boolean canProcess(MenuItem item) {
        return item.getProcessorType().equals("SAUCE");
    }
    @Override
    public void process(MenuItem item) {
        System.out.println("[SAUCE DISPENSER] Preparing " + item.getName());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[DONE] " + item.getName());
    }
}
