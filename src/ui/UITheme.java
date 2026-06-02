package ui;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public final class UITheme {
    public static final Color SKY_TOP = new Color(120, 190, 255);
    public static final Color SKY_BOTTOM = new Color(230, 244, 255);
    public static final Color PANEL_BG = new Color(255, 255, 255, 235);
    public static final Color PANEL_BORDER = new Color(121, 170, 214);
    public static final Color BUTTON_BG = new Color(66, 133, 244);
    public static final Color BUTTON_FG = Color.WHITE;
    public static final Color TEXT_BG = new Color(246, 251, 255);
    public static final Color TEXT_FG = new Color(36, 57, 82);

    private UITheme() {
    }

    public static void stylePanel(JPanel panel, String title) {
        panel.setOpaque(false);
        panel.setBorder(BorderFactory.createCompoundBorder(
                new LineBorder(PANEL_BORDER, 2, true),
                new CompoundBorder(
                        BorderFactory.createTitledBorder(
                                new EmptyBorder(0, 0, 0, 0),
                                title,
                                TitledBorder.LEFT,
                                TitledBorder.TOP,
                                new Font("SansSerif", Font.BOLD, 14),
                                TEXT_FG
                        ),
                        new EmptyBorder(8, 10, 10, 10)
                )
        ));
    }

    public static void styleButton(AbstractButton button) {
        button.setBackground(BUTTON_BG);
        button.setForeground(BUTTON_FG);
        button.setFocusPainted(false);
        button.setFont(new Font("SansSerif", Font.BOLD, 13));
        button.setBorder(new EmptyBorder(7, 12, 7, 12));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void styleDarkButton(AbstractButton button) {
        styleButton(button);
        button.setBackground(new Color(20, 20, 20));
    }

    public static void styleTextArea(JTextArea area) {
        area.setBackground(TEXT_BG);
        area.setForeground(TEXT_FG);
        area.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 13));
        area.setLineWrap(false);
        area.setWrapStyleWord(false);
        area.setBorder(new EmptyBorder(10, 10, 10, 10));
    }

    public static JScrollPane wrap(JTextArea area) {
        JScrollPane scrollPane = new JScrollPane(area);
        scrollPane.setBorder(new LineBorder(PANEL_BORDER, 1, true));
        scrollPane.getViewport().setBackground(TEXT_BG);
        scrollPane.setOpaque(false);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        return scrollPane;
    }

    public static JPanel createCardLayout() {
        JPanel panel = new JPanel();
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout(0, 10));
        return panel;
    }
}
