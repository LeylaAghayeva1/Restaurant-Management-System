package ui;

import javax.swing.*;
import java.awt.*;
import engine.RestaurantEngine;

public class DashboardFrame extends JFrame {

    private final RestaurantEngine engine;
    private final OrdersPanel ordersPanel;
    private final InventoryPanel inventoryPanel;
    private final SystemLogPanel systemLogPanel;

    public DashboardFrame() {
        engine = new RestaurantEngine();
        ordersPanel = new OrdersPanel(engine);
        inventoryPanel = new InventoryPanel(engine);
        RestockPanel restockPanel = new RestockPanel(engine, this::refreshPanels);
        systemLogPanel = new SystemLogPanel();
        ControlPanel controlPanel = new ControlPanel(engine, this::refreshPanels);
        SkyPanel rootPanel = new SkyPanel(new BorderLayout(18, 18));
        JPanel centerPanel = new JPanel(new GridBagLayout());
        JPanel southPanel = new JPanel(new BorderLayout());

        setTitle("Silicon Spatula");
        setSize(1440, 920);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setContentPane(rootPanel);

        rootPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        centerPanel.setOpaque(false);
        southPanel.setOpaque(false);
        southPanel.setPreferredSize(new Dimension(0, 210));

        ordersPanel.setPreferredSize(new Dimension(320, 0));
        inventoryPanel.setPreferredSize(new Dimension(660, 0));
        restockPanel.setPreferredSize(new Dimension(240, 0));

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridy = 0;
        constraints.fill = GridBagConstraints.BOTH;
        constraints.insets = new Insets(0, 0, 0, 18);
        constraints.weighty = 1.0;

        constraints.gridx = 0;
        constraints.weightx = 0.26;
        centerPanel.add(ordersPanel, constraints);

        constraints.gridx = 1;
        constraints.weightx = 0.56;
        centerPanel.add(inventoryPanel, constraints);

        constraints.gridx = 2;
        constraints.weightx = 0.18;
        constraints.insets = new Insets(0, 0, 0, 0);
        centerPanel.add(restockPanel, constraints);

        southPanel.add(systemLogPanel, BorderLayout.CENTER);

        add(controlPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);

        setLocationRelativeTo(null);
        refreshPanels();
        engine.start(this::refreshPanels);
        setVisible(true);
    }

    private void refreshPanels() {
        ordersPanel.refresh();
        inventoryPanel.refresh();
        systemLogPanel.refresh();
    }
}
