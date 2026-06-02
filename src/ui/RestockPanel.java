package ui;
import javax.swing.*;
import java.awt.*;
import engine.RestaurantEngine;
import model.inventory.Ingredient;
import model.log.LogManager;
public class RestockPanel extends JPanel {
    public RestockPanel(RestaurantEngine engine, Runnable refreshAction) {
        setLayout(new BorderLayout(0, 12));
        UITheme.stylePanel(this, "Restock");
        setPreferredSize(new Dimension(240, 560));
        Ingredient[] ingredients = Ingredient.values();
        JComboBox<Ingredient> ingredientBox = new JComboBox<>(ingredients);
        JButton restockButton = new JButton("Restock");
        JLabel infoLabel = new JLabel("Refill ingredients from available budget");
        JPanel controlsPanel = new JPanel(new GridLayout(2, 1, 0, 10));
        controlsPanel.setOpaque(false);
        ingredientBox.setFont(new Font("SansSerif", Font.PLAIN, 14));
        ingredientBox.setBackground(Color.WHITE);
        ingredientBox.setForeground(UITheme.TEXT_FG);
        infoLabel.setForeground(new Color(70, 96, 125));
        UITheme.styleButton(restockButton);
        restockButton.addActionListener(e -> {
            Ingredient selected = (Ingredient) ingredientBox.getSelectedItem();

            if (selected != null) {
                boolean success = engine.getInventory().restock(selected);

                if (success) {
                    LogManager.log("[RESTOCKED] " + selected);
                } else {
                    LogManager.log("[ERROR] Could not restock " + selected + ". Not enough money.");
                }

                refreshAction.run();
            }
        });
        controlsPanel.add(ingredientBox);
        controlsPanel.add(restockButton);
        add(infoLabel, BorderLayout.NORTH);
        add(controlsPanel, BorderLayout.CENTER);
    }
}