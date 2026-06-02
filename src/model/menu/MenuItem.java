package model.menu;
import model.inventory.Ingredient;
import java.util.*;
public abstract class MenuItem {
    protected String name;
    protected double price;
    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }
    public abstract Map<Ingredient, Integer> getRequiredIngredients();
    public abstract String getProcessorType();
}
