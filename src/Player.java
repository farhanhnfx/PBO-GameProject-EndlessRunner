import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Player extends JLabel implements ActionListener {
    public static final int width = 64;
    public static final int height = 120;
    private ImageIcon carImg;
    public static int posX = 100;
    public static int posY = 448;
    private final int[] availablePosX = {100, 176, 270, 346};
    private int movementInt;
    private int health;
    private boolean isCollided;
    private final Timer collideTimer = new Timer(1000, this);  // bar collide tak gawe invisible 1 detik
    public int score = 0;   // sementara, sesuk diubah ke class sendiri

    public Player() {
        setBounds(posX, posY, width, height);
        carImg = new ImageIcon("src/assets/Car.png");
        setIcon(carImg);
        movementInt = 0;
        health = 7;
        isCollided = false;
    }
    
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public boolean isCollided() {
        return isCollided;
    }
    public void decreaseHealth(int damage) {
        this.isCollided = true;
        if (health > 0) {
            health -= damage;
            System.out.println("Nyawa player: " + health);
        }
        else {
            System.out.println("GAWE STATE GAME OVER");
        }
        collideTimer.start();
    }
    public boolean canMove() {
        if (movementInt >= 0 && movementInt <= 3) {
            return true;
        }
        return false;
    }
    public void moveRight() {
        if (movementInt < 3) {
            movementInt++;
        }
        if (canMove()) {
            posX = availablePosX[movementInt];
        }
        setLocation(posX, posY);
    }
    public void moveLeft() {
        if (movementInt > 0) {
            movementInt--;
        }
        if (canMove()) {
            posX = availablePosX[movementInt];
        }
        setLocation(posX, posY);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        this.isCollided = false;
        collideTimer.stop();
    }
    
}
