import java.awt.*;
import javax.swing.*;

public class ObstacleSpawner extends JPanel {

    // DURUNG KEGARAP
    // coming soon aja

    public ObstacleSpawner() {
        setBounds(0, 0, GamePanel.width, GamePanel.height);
        setBackground(new Color(255, 255, 255, 0));
        // setOpaque(false);
        JLabel l = new JLabel("UASUYWHFUWEWUIEF");
        // l.setBounds(50, 100, 300, 300);
        add(l);
    }
}
