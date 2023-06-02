import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Graphics;

public class Bar extends JLabel {
    private final int width = 16;
    private Color color;

    public Bar(Color c) {
        this.color = c;
        setSize(width, width);
        setBounds(getVisibleRect());
        // System.out.println(getBounds());
    }

    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, width, width);
    }
    
}
