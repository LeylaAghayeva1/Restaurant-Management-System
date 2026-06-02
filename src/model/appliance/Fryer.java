package model.appliance;
import model.menu.MenuItem;
public class Fryer implements IAppliance {
    @Override
    public boolean canProcess(MenuItem item) {
        return item.getProcessorType().equals("FRYER");
    }
    @Override
    public void process(MenuItem item) {
        System.out.println("[FRYER] Cooking " + item.getName());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[DONE] " + item.getName());
    }
}