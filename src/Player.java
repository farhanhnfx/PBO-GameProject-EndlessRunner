import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Player extends JPanel implements KeyListener, ActionListener {
    public static final int width = 128;
    public static final int height = 240;
    private ImageIcon carImg;
    public static JLabel carLabel;
    public static int posX = 272;
    public static int posY = 320;
    private final Timer timer = new Timer(1000, this);
    private static int newXLoc;

    public Player() {
        carImg = new ImageIcon("src/assets/Car.png");
        carLabel = new JLabel(carImg);
        carLabel.setBounds(posX, posY, width, height);
        // System.out.println(posX + ", " + posY);
        // add(carLabel);
        // timer.start(); // test timer

        // addKeyListener(new KeyListener() {
        //     @Override
        //     public void keyTyped(KeyEvent e) {
        //         // TODO Auto-generated method stub
                
        //     }

        //     @Override
        //     public void keyPressed(KeyEvent e) {
        //         // TODO Auto-generated method stub
        //         int keyCode = e.getKeyCode();
        //         switch (keyCode) {
        //             case KeyEvent.VK_LEFT:
        //                 Player.posX -= Player.width - 40;
        //                 // Player.moveLeft();
        //                 break;
        //             case KeyEvent.VK_RIGHT:
        //                 Player.posX += Player.width + 40;
        //                 // Player.moveRight();
        //                 break;
        //         }
        //         setLocation(Player.posX, Player.posY);
        //     }

        //     @Override
        //     public void keyReleased(KeyEvent e) {
        //         // TODO Auto-generated method stub
                
        //     }
        // });
    }
    
    public int getPosX() {
        return posX;
    }

    // public void setPosX(int posX) {
    //     this.posX = posX;
    // }

    public int getPosY() {
        return posY;
    }

    // public void setPosY(int posY) {
    //     this.posY = posY;
    // }

    public JLabel getCarLabel() {
        return this.carLabel;
    }
    // public static void moveRight() {
    //     newXLoc = posX + width + 40;
    // }
    // public static void moveLeft() {
    //     newXLoc = posX - width - 40;
    // }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        System.out.println(e + "pressed");
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        System.out.println("xxxx");
    }
    
}
