package ui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import engine.RestaurantEngine;
import model.inventory.Ingredient;
import model.inventory.IngredientInfo;
import model.inventory.IngredientRegistry;

public class InventoryPanel extends JPanel {

    private final RestaurantEngine engine;
    private final JTextArea inventoryArea;

    public InventoryPanel(RestaurantEngine engine) {
        this.engine = engine;
        setLayout(new BorderLayout(0, 10));
        UITheme.stylePanel(this, "Inventory");
        setPreferredSize(new Dimension(660, 560));

        inventoryArea = new JTextArea(24, 48);
        inventoryArea.setEditable(false);
        UITheme.styleTextArea(inventoryArea);

        JButton refresh = new JButton("Refresh Inventory");
        UITheme.styleButton(refresh);

        refresh.addActionListener(e -> refresh());

        add(UITheme.wrap(inventoryArea), BorderLayout.CENTER);
        add(refresh, BorderLayout.SOUTH);
    }

    public void refresh() {
        StringBuilder builder = new StringBuilder();
        builder.append("Money: $").append(String.format("%.2f", engine.getInventory().getMoney())).append('\n');
        builder.append('\n');

        List<Map.Entry<Ingredient, Integer>> entries = new ArrayList<>(engine.getInventory().getStockSnapshot().entrySet());
        entries.sort(Comparator.comparing(entry -> displayNameFor(entry.getKey())));

        for (Map.Entry<Ingredient, Integer> entry : entries) {
            builder.append(displayNameFor(entry.getKey()))
                    .append(": ")
                    .append(entry.getValue())
                    .append(' ')
                    .append(unitFor(entry.getKey()))
                    .append('\n');
        }
        inventoryArea.setText(builder.toString());
    }

    private String displayNameFor(Ingredient ingredient) {
        IngredientInfo info = IngredientRegistry.getInfo(ingredient);
        return info != null ? info.getDisplayName() : ingredient.name();
    }

    private String unitFor(Ingredient ingredient) {
        IngredientInfo info = IngredientRegistry.getInfo(ingredient);
        return info != null ? info.getUnit() : "units";
    }
}
