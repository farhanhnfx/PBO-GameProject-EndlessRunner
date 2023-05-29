import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class RoadMark extends JPanel implements Runnable {
    public static final int width = 8;
    public static final int height = 128;
    public static final Color color = new Color(253, 187, 60);
    // public static final Color color = Color.red;
    public static final int posX = GamePanel.width/2 - width/2;     // center of screen
    // private final Timer timer = new Timer(0, this);
    private int posY;
    private Thread spawn;

    public RoadMark(int posY) {
        setBounds(posX, posY, width, height);
        this.posY = posY;   // initial vertical position
        // timer.start();
        spawn = new Thread(this);
        spawn.start();
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
        g.fillRect(0, 0, width, height);
    }

    @Override
    public void run() {
        // TODO Auto-generated method stub
        while (spawn != null) {
            this.setLocation(posX, posY);
            this.addPosY();
            try {
                Thread.sleep(0, 1);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    // @Override
    // public void actionPerformed(ActionEvent e) {
    //     // TODO Auto-generated method stub
    //     this.setLocation(posX, posY);
    //     this.addPosY();
    //     // repaint();
    // }

    // @Override
    // public Dimension getPreferredSize() {
    //     return new Dimension(width, height);
    // }
    
}
