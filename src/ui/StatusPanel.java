package ui;

import javax.swing.*;
import java.awt.*;

public class StatusPanel extends JPanel {

    public StatusPanel() {
        setLayout(new FlowLayout());

        JLabel statusLabel = new JLabel("System Status: Ready");
        JButton updateButton = new JButton("Update Status");

        updateButton.addActionListener(e -> {
            statusLabel.setText("System Status: Running");
        });

        add(statusLabel);
        add(updateButton);
    }
}
