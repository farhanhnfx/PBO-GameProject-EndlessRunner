import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HealthBar extends JPanel {
    private ArrayList<Bar> bars;

    public HealthBar() {
        setSize(112, 16);
        setLocation(16, 80);
        setLayout(new GridLayout());
        setBackground(new Color(92, 92, 92));

        bars = new ArrayList<>();
        bars.add(new Bar(new Color(223, 44, 58)));
        bars.add(new Bar(new Color(223, 87, 44)));
        bars.add(new Bar(new Color(223, 119, 44)));
        bars.add(new Bar(new Color(223, 173, 44)));
        bars.add(new Bar(new Color(198, 223, 44)));
        bars.add(new Bar(new Color(144, 223, 44)));
        bars.add(new Bar(new Color(32, 207, 49)));

        for (Bar bar : bars) {
            add(bar);
            bar.setVisible(false);
        }
    }
    
    public ArrayList<Bar> getBars() {
        return bars;
    }
}
