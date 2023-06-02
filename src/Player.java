import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import javax.swing.*;

public class Player extends JLabel implements ActionListener, KeyListener {
    public static final int width = 64;
    public static final int height = 120;
    private ImageIcon carImg;
    private int posX = 100;
    private int posY = 448;
    private final int[] availablePosX = {100, 176, 270, 346};
    private int movementInt;
    private Random random;
    private int health;
    private boolean isCollided;
    private final Timer collideTimer = new Timer(500, this);  // bar collide tak gawe invisible 0.5 detik

    public Player() {
        carImg = new ImageIcon("src/assets/Car.png");
        setIcon(carImg);
        random = new Random();
        int randomPos = random.nextInt(availablePosX.length);
        movementInt = randomPos;
        posX = availablePosX[randomPos];
        health = 7;
        isCollided = false;
        setBounds(posX, posY, width, height);
        setFocusable(true);
        setVisible(true);
        addKeyListener(this);
        // System.out.println("player spawn");
        GameManager.board.updateHealth(health);
    }
    
    public int getPosX() {
        return posX;
    }
    public int getPosY() {
        return posY;
    }
    public int getHealth() {
        return health;
    }
    public boolean isCollided() {
        return isCollided;
    }
    public void decreaseHealth(int damage) {
        this.isCollided = true;
        health -= damage;
        if (health <= 0) {
            GameManager.isOver(true);
        }
        if (health < 0) {
            health = 0;
        }
        GameManager.board.updateHealth(health);
        collideTimer.setRepeats(false);
        collideTimer.start();
    }
    public boolean canMove() {
        if (movementInt >= 0 && movementInt <= 3 && !GameManager.isGameOver) {
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
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                // Player.posX -= Player.width + 40;
                moveLeft();
                break;
            case KeyEvent.VK_RIGHT:
                // Player.posX += Player.width + 40;
                moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }
    
}
