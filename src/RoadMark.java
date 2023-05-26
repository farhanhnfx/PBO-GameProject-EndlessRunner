import java.awt.*;
import javax.swing.*;

public class RoadMark extends JPanel {
    public static final int width = 16;
    public static final int height = 128;
    public static final Color color = new Color(217, 217, 217);
    public static final int posX = GamePanel.width/2 - width/2;     // center of screen
    private int posY;

    public RoadMark(int posY) {
        this.posY = posY;   // initial vertical position
    }

    public int getPosY() {
        return posY;
    }
    public void addPosY() {
        this.posY++;
        if (this.posY > GamePanel.height + height) {
            posY = -height;
        }
    }

    // draw road mark
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.drawRect(posX, posY, width, height);
    }

    // @Override
    // public Dimension getPreferredSize() {
    //     return new Dimension(width, height);
    // }
    
}
