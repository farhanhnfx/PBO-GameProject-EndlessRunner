package GameObjects;
import java.awt.*;

import javax.swing.*;

import Gameplay.GameManager;
import Gameplay.GamePanel;

public class RoadMark extends JPanel  {
    public static final int width = 8;
    public static final int height = 64;
    private final Color color = new Color(253, 187, 60);
    private final int posX = 168;
    // private final Timer timer = new Timer(0, this);
    private int posY;

    public RoadMark(int posY) {
        // setBackground(new Color(0, 0, 0, 0));
        this.posY = posY;   // initial vertical position
        setBounds(posX, posY, GamePanel.width, GamePanel.height);
    }

    public int getPosY() {
        return posY;
    }
    public void moveDown() {
        this.posY += GameManager.OBS_SPEED;
        if (this.posY > GamePanel.height + height) {
            posY = -height;
        }
        setLocation(posX, posY);
    }

    // draw road mark
    @Override
    protected void paintComponent(Graphics g) {
        // super.paintComponent(g);
        g.setColor(color);
        g.fillRect(0, 0, width, height);
        g.fillRect(posX, 0, width, height);

        Graphics2D graphics2D = (Graphics2D) g;
    
        //Set  anti-alias!
        graphics2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON); 
    }
    
}
