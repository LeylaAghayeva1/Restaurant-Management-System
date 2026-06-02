package ui;

import javax.swing.*;
import java.awt.*;

public class SkyPanel extends JPanel {
    public SkyPanel(LayoutManager layout) {
        super(layout);
        setOpaque(true);
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D g2 = (Graphics2D) graphics.create();
        g2.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
        g2.setPaint(new GradientPaint(0, 0, UITheme.SKY_TOP, 0, getHeight(), UITheme.SKY_BOTTOM));
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(new Color(255, 255, 255, 90));
        g2.fillOval(40, 40, 180, 60);
        g2.fillOval(140, 55, 140, 45);
        g2.fillOval(getWidth() - 260, 70, 170, 55);
        g2.fillOval(getWidth() - 170, 50, 120, 42);
        g2.dispose();
    }
}
