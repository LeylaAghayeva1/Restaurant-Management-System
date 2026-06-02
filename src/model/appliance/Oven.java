package model.appliance;
import model.menu.MenuItem;
public class Oven implements IAppliance {
    @Override
    public boolean canProcess(MenuItem item) {
        return item.getProcessorType().equals("OVEN");
    }
    @Override
    public void process(MenuItem item) {
        System.out.println("[OVEN] Cooking " + item.getName());
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        System.out.println("[DONE] " + item.getName());
    }
}
