package app;

import javax.swing.SwingUtilities;
import ui.DashboardFrame;

public class MainApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(DashboardFrame::new);
    }
}
