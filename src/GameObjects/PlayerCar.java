package GameObjects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.*;

import Gameplay.GameManager;
import Resources.ResourceManager;

public class PlayerCar extends ColliderObject implements ActionListener, KeyListener {
    private int health;
    public boolean collidedWithObstacle;
    public boolean collidedWithPowerUp;
    private final Timer collideTimer = new Timer(600, this);  // bar collide tak gawe invisible 0.5 detik
    public static final int MAX_HEALTH = 7;

    public PlayerCar() {
        super.img = ResourceManager.PLAYER_CAR;
        addSpawnPosX(100);
        addSpawnPosX(176);
        addSpawnPosX(270);
        addSpawnPosX(346);
        setPosY(448);
        setImg(img);
        setFocusable(true);
        setVisible(true);
        addKeyListener(this);
        spawn();
    }
    
    public int getHealth() {
        return health;
    }
    public void spawn() {
        int randomPos = GameManager.rand.nextInt(getSpawnPosX().size());
        setMovementInt(randomPos);
        setPosX(getSpawnPosX().get(randomPos));
        health = MAX_HEALTH;
        collidedWithObstacle = false;
        collidedWithPowerUp = false;
        setBounds(getPosX(), getPosY(), width, height);
        GameManager.board.updateHealth(health);
    }
    public void decreaseHealth(int damage) {
        this.collidedWithObstacle = true;
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
        // this.collidedWithRoadHole = true;
        this.collidedWithPowerUp = true;
        health += point;
        if (health > 7) {
            health = MAX_HEALTH;
        }
        GameManager.board.updateHealth(health);
        collideTimer.setRepeats(false);
        collideTimer.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.collidedWithObstacle = false;
        this.collidedWithPowerUp = false;
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
