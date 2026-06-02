package ui;

import javax.swing.*;
import java.awt.*;
import model.log.LogManager;

public class SystemLogPanel extends JPanel {

    private final JTextArea logArea;

    public SystemLogPanel() {
        setLayout(new BorderLayout(0, 10));
        UITheme.stylePanel(this, "System Log");
        setPreferredSize(new Dimension(0, 210));

        logArea = new JTextArea(10, 100);
        logArea.setEditable(false);
        UITheme.styleTextArea(logArea);

        add(UITheme.wrap(logArea), BorderLayout.CENTER);
    }

    public void refresh() {
        StringBuilder builder = new StringBuilder();
        for (String log : LogManager.getLogs()) {
            builder.append(log).append('\n');
        }
        if (builder.length() == 0) {
            builder.append("No logs yet.");
        }
        logArea.setText(builder.toString());
    }
}
