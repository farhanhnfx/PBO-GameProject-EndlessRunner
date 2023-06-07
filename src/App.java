import javax.swing.SwingUtilities;

import Gameplay.GamePanel;

public class App {
    public static void main(String[] args) throws Exception {
        SwingUtilities.invokeLater(() -> {
            new GamePanel();
        });
    }
}
