import java.awt.*;

import javax.swing.*;

public class RoadMark extends JPanel  {
    public static final int width = 8;
    public static final int height = 64;
    public static final Color color = new Color(253, 187, 60);
    // public static final int posX = GamePanel.width/2 - width/2;     // center of screen
    public static final int posX = 168;
    // private final Timer timer = new Timer(0, this);
    private int posY;

    public RoadMark(int posY) {
        setBounds(posX, 0, GamePanel.width, GamePanel.height);
        setBackground(new Color(0, 0, 0, 0));
        this.posY = posY;   // initial vertical position
    }

    public int getPosY() {
        return posY;
    }
    public void addPosY() {
        this.posY += 8;
        if (this.posY > GamePanel.height + height) {
            posY = -height;
        }
        setLocation(posX, posY);
    }

    // draw road mark
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.fillRect(posX, 0, width, height);
    }
    
}
