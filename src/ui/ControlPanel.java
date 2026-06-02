package ui;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import engine.RestaurantEngine;
import model.log.LogManager;
import persistence.StateManager;
public class ControlPanel extends JPanel {
    private final Runnable refreshAction;
    public ControlPanel(RestaurantEngine engine, Runnable refreshAction) {
        this.refreshAction = refreshAction;
        setLayout(new BorderLayout(12, 8));
        UITheme.stylePanel(this, "Control Deck");
        JLabel title = new JLabel("Silicon Spatula");
        JLabel subtitle = new JLabel("Live kitchen queue and persistence");
        JPanel headerPanel = new JPanel(new GridLayout(2, 1, 0, 2));
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT, 12, 0));
        JButton processButton = new JButton("Cook Next Order");
        JButton saveButton = new JButton("Save");
        JButton loadButton = new JButton("Load");
        title.setFont(new Font("SansSerif", Font.BOLD, 20));
        title.setForeground(UITheme.TEXT_FG);
        subtitle.setFont(new Font("SansSerif", Font.PLAIN, 12));
        subtitle.setForeground(new Color(70, 96, 125));
        headerPanel.setOpaque(false);
        buttonPanel.setOpaque(false);
        headerPanel.setBorder(BorderFactory.createEmptyBorder(4, 0, 0, 0));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(16, 0, 4, 0));
        UITheme.styleDarkButton(processButton);
        UITheme.styleDarkButton(saveButton);
        UITheme.styleDarkButton(loadButton);
        processButton.addActionListener(e -> engine.processNextOrder(this.refreshAction));
        saveButton.addActionListener(e -> {
            StateManager.save(
                    "save.txt",
                    engine.getInventory().getStockSnapshot(),
                    engine.getInventory().getMoney(),
                    engine.getQueue()
            );
            LogManager.log("[SAVE] Game saved successfully.");
            this.refreshAction.run();
        });
        loadButton.addActionListener(e -> {
            File file = new File("save.txt");
            if (!file.exists()) {
                LogManager.log("[ERROR] No saved file found.");
                this.refreshAction.run();
                return;
            }
            StateManager.LoadedState state = StateManager.load("save.txt");

            if (state.getStock().isEmpty() && state.getQueue().isEmpty() && state.getMoney() == 0) {
                LogManager.log("[ERROR] Save file could not be loaded correctly.");
                this.refreshAction.run();
                return;
            }

            engine.getInventory().restoreState(new HashMap<>(state.getStock()), state.getMoney());
            engine.restoreQueue(state.getQueue());

            LogManager.log("[LOAD] Game loaded successfully.");
            this.refreshAction.run();
        });
        headerPanel.add(title);
        headerPanel.add(subtitle);
        buttonPanel.add(processButton);
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);

        add(headerPanel, BorderLayout.WEST);
        add(buttonPanel, BorderLayout.CENTER);
    }
    @Override
    public Dimension getPreferredSize() {
        Dimension preferredSize = super.getPreferredSize();
        return new Dimension(preferredSize.width, 132);
    }
}