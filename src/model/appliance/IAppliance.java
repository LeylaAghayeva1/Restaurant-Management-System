package model.appliance;
import model.menu.MenuItem;
public interface IAppliance {
    boolean canProcess(MenuItem item);
    void process(MenuItem item);
}