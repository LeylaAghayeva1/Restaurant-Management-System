package model.inventory;
import java.util.HashMap;
import java.util.Map;
public class InventoryManager {
    private final HashMap<Ingredient, Integer> stock;
    private double money;
    public InventoryManager(double startingMoney) {
        if (startingMoney < 0) {
            throw new IllegalArgumentException("Starting money cannot be negative.");
        }
        this.stock = new HashMap<>();
        this.money = startingMoney;
    }
    public void initializeDefaultStock() {
        stock.clear();

        // Main ingredients
        stock.put(Ingredient.PEPPERONI, 200);
        stock.put(Ingredient.GROUND_BEEF, 5000);
        stock.put(Ingredient.BREAST, 20);
        stock.put(Ingredient.FROZEN_NUGGETS, 40);
        stock.put(Ingredient.CHEESE, 40);
        stock.put(Ingredient.LETTUCE, 30);
        stock.put(Ingredient.TOMATO, 40);
        stock.put(Ingredient.ONION, 30);
        stock.put(Ingredient.MUSHROOM, 40);
        stock.put(Ingredient.PICKLE, 70);
        stock.put(Ingredient.GARLIC, 50);
        stock.put(Ingredient.PEPPER, 30);
        stock.put(Ingredient.POTATO, 30);
        stock.put(Ingredient.BUN, 25);
        stock.put(Ingredient.DOUGH, 25);

        // Sauces
        stock.put(Ingredient.KETCHUP, 500);
        stock.put(Ingredient.MAYO, 500);
        stock.put(Ingredient.PIZZA_SAUCE, 500);
        stock.put(Ingredient.BARBECUE_SAUCE, 500);

        // Drinks
        stock.put(Ingredient.COLA_SYRUP, 3000);
        stock.put(Ingredient.SPRITE_SYRUP, 3000);
        stock.put(Ingredient.FANTA_SYRUP, 3000);
        stock.put(Ingredient.WATER, 5000);
        stock.put(Ingredient.ICE_CUBES, 100);

        // Packaging
        stock.put(Ingredient.PIZZA_BOX, 20);
        stock.put(Ingredient.CUP, 50);
        stock.put(Ingredient.SAUCE_BOWL, 30);
    }
    public double getMoney() {
        return money;
    }
    public void addMoney(double amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("Cannot add negative money.");
        }
        money += amount;
    }
    public boolean spendMoney(double amount) {
        if (amount < 0) {
            return false;
        }
        if (money < amount) {
            return false;
        }
        money -= amount;
        return true;
    }
    public int getQuantity(Ingredient ingredient) {
        if (ingredient == null) {
            return 0;
        }
        return stock.getOrDefault(ingredient, 0);
    }
    public Map<Ingredient, Integer> getStockSnapshot() {
        return new HashMap<>(stock);
    }
    public boolean hasEnough(Map<Ingredient, Integer> requiredIngredients) {
        if (requiredIngredients == null) {
            throw new IllegalArgumentException("Required ingredients cannot be null.");
        }
        for (Map.Entry<Ingredient, Integer> entry : requiredIngredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();
            if (ingredient == null || requiredAmount == null || requiredAmount < 0) {
                return false;
            }
            int availableAmount = stock.getOrDefault(ingredient, 0);
            if (availableAmount < requiredAmount) {
                return false;
            }
        }
        return true;
    }
    public HashMap<Ingredient, Integer> getMissingIngredients(Map<Ingredient, Integer> requiredIngredients) {
        if (requiredIngredients == null) {
            throw new IllegalArgumentException("Required ingredients cannot be null.");
        }
        HashMap<Ingredient, Integer> missing = new HashMap<>();
        for (Map.Entry<Ingredient, Integer> entry : requiredIngredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            Integer requiredAmount = entry.getValue();
            if (ingredient == null || requiredAmount == null || requiredAmount < 0) {
                continue;
            }
            int availableAmount = stock.getOrDefault(ingredient, 0);
            if (availableAmount < requiredAmount) {
                missing.put(ingredient, requiredAmount - availableAmount);
            }
        }
        return missing;
    }
    public boolean consume(Map<Ingredient, Integer> requiredIngredients) {
        if (!hasEnough(requiredIngredients)) {
            return false;
        }
        for (Map.Entry<Ingredient, Integer> entry : requiredIngredients.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int requiredAmount = entry.getValue();
            int currentAmount = stock.getOrDefault(ingredient, 0);
            int newAmount = currentAmount - requiredAmount;
            if (newAmount < 0) {
                return false;
            }
            stock.put(ingredient, newAmount);
        }
        return true;
    }
    public boolean restock(Ingredient ingredient) {
        if (ingredient == null) {
            return false;
        }
        IngredientInfo info = IngredientRegistry.getInfo(ingredient);
        if (info == null) {
            return false;
        }
        int restockAmount = info.getRestockAmount();
        double restockCost = info.getRestockCost();
        if (restockAmount <= 0 || restockCost < 0) {
            return false;
        }
        if (money < restockCost) {
            return false;
        }
        money -= restockCost;
        stock.put(ingredient, stock.getOrDefault(ingredient, 0) + restockAmount);
        return true;
    }
    public boolean restock(Ingredient ingredient, int amount, double cost) {
        if (ingredient == null || amount <= 0 || cost < 0) {
            return false;
        }
        if (money < cost) {
            return false;
        }
        money -= cost;
        stock.put(ingredient, stock.getOrDefault(ingredient, 0) + amount);
        return true;
    }
    public void restoreState(Map<Ingredient, Integer> restoredStock, double restoredMoney) {
        if (restoredStock == null) {
            throw new IllegalArgumentException("Restored stock cannot be null.");
        }
        if (restoredMoney < 0) {
            throw new IllegalArgumentException("Restored money cannot be negative.");
        }
        stock.clear();
        for (Map.Entry<Ingredient, Integer> entry : restoredStock.entrySet()) {
            Ingredient ingredient = entry.getKey();
            Integer amount = entry.getValue();
            if (ingredient == null || amount == null || amount < 0) {
                throw new IllegalArgumentException("Restored stock contains invalid data.");
            }
            stock.put(ingredient, amount);
        }
        this.money = restoredMoney;
    }
}