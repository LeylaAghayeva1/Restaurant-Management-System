package model.inventory;
public class IngredientInfo {
    private final String displayName;
    private final String unit;
    private final int restockAmount;
    private final double restockCost;
    public IngredientInfo(String displayName, String unit, int restockAmount, double restockCost) {
        if (displayName == null || displayName.isBlank()) {
            throw new IllegalArgumentException("Display name cannot be empty");
        }
        this.displayName = displayName;
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException("Unit cannot be empty");
        }
        this.unit = unit;
        if (restockAmount <= 0) {
            throw new IllegalArgumentException("Restock amount must be positive");
        }
        this.restockAmount = restockAmount;
        if (restockCost < 0) {
            throw new IllegalArgumentException("Restock cost cannot be negative");
        }
        this.restockCost = restockCost;
    }
    public String getDisplayName() {
        return displayName;
    }
    public String getUnit() {
        return unit;
    }
    public int getRestockAmount() {
        return restockAmount;
    }
    public double getRestockCost() {
        return restockCost;
    }
    @Override
    public String toString() {
        return displayName + " (" + unit + ")";
    }
}