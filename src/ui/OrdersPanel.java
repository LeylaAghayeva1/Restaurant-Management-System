package ui;

import javax.swing.*;
import java.awt.*;
import engine.RestaurantEngine;
import model.order.Order;

public class OrdersPanel extends JPanel {

    private final RestaurantEngine engine;
    private final JTextArea ordersArea;

    public OrdersPanel(RestaurantEngine engine) {
        this.engine = engine;
        setLayout(new BorderLayout(0, 10));
        UITheme.stylePanel(this, "Orders");
        setPreferredSize(new Dimension(320, 560));

        ordersArea = new JTextArea(24, 28);
        ordersArea.setEditable(false);
        UITheme.styleTextArea(ordersArea);

        JButton refresh = new JButton("Refresh Orders");
        UITheme.styleButton(refresh);

        refresh.addActionListener(e -> refresh());

        add(UITheme.wrap(ordersArea), BorderLayout.CENTER);
        add(refresh, BorderLayout.SOUTH);
    }

    public void refresh() {
        StringBuilder builder = new StringBuilder();
        for (Order order : engine.getOrders()) {
            builder.append(order).append('\n');
        }
        if (builder.length() == 0) {
            builder.append("No orders in queue.");
        }
        ordersArea.setText(builder.toString());
    }
}
