package model.appliance;
import model.menu.MenuItem;
public class DrinkDispenser implements IAppliance {
    @Override
    public boolean canProcess(MenuItem item) {
        return item.getProcessorType().equals("DRINK");
    }
    @Override
    public void process(MenuItem item) {
        System.out.println("[DRINK DISPENSER] Preparing " + item.getName());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[DONE] " + item.getName());
    }
}