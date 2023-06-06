import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

public class Player extends JLabel implements ActionListener, KeyListener {
    public static final int width = 64;
    public static final int height = 120;
    private ImageIcon carImg;
    private int posX;
    private final int posY = 448;
    private final int[] availablePosX = {100, 176, 270, 346};
    private int movementInt;
    private int health;
    public boolean isCollided;
    private final Timer collideTimer = new Timer(600, this);  // bar collide tak gawe invisible 0.5 detik
    public static final int MAX_HEALTH = 7;

    public Player() {
        carImg = ResourceManager.PLAYER_CAR;
        setIcon(carImg);
        setFocusable(true);
        setVisible(true);
        addKeyListener(this);
        spawn();
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
    public void spawn() {
        int randomPos = GameManager.rand.nextInt(availablePosX.length);
        movementInt = randomPos;
        posX = availablePosX[randomPos];
        health = MAX_HEALTH;
        isCollided = false;
        setBounds(posX, posY, width, height);
        GameManager.board.updateHealth(health);
    }
    public void decreaseHealth(int damage) {
        this.isCollided = true;
        health -= damage;
        if (health <= 0) {
            health = 0;
            GameManager.isGameOver = true;
        }
        GameManager.board.updateHealth(health);
        collideTimer.setRepeats(false);
        collideTimer.start();
    }

    public void increaseHealth(int point) {
        this.isCollided = true;
        health += point;
        if (health > 7) {
            health = MAX_HEALTH;
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
        this.isCollided = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                moveLeft();
                break;
            case KeyEvent.VK_A:
                moveLeft();
                break;
            case KeyEvent.VK_D:
                moveRight();
                break;
            case KeyEvent.VK_RIGHT:
                moveRight();
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
