package GameObjects;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.Timer;

import Gameplay.GameManager;
import Gameplay.GamePanel;
import Resources.ResourceManager;

public class NonPlayableCar extends Obstacle implements ActionListener {
    private boolean obstacleAhead;
    private Timer timer = new Timer(500, this);
    private final ImageIcon[] carImgs = ResourceManager.NPC_CARS;
    private int speed;

    public NonPlayableCar() {
        addSpawnPosX(100);
        addSpawnPosX(176);
        addSpawnPosX(270);
        addSpawnPosX(346);
        setDamage(PlayerCar.MAX_HEALTH);
        initPosY = -500;
        spawn();
        timer.setRepeats(false);
    }

    public void spawn() {
        // super.img = getRandomImg();
        // setPosX(getRandomX());
        setPosX(GameManager.player.getPosX());
        setMovementInt(GameManager.player.getMovementInt());
        setPosY(initPosY);
        obstacleAhead = false;
        speed = GameManager.NPC_SPEED;
        setImg(getRandomImg());
    }
    @Override
    public void moveDown() {
        setPosY(getPosY() + speed);
        // if (this.posY < -height) { // < -height if from bottom to up
        if (getPosY() > GamePanel.height) {
            spawn();
        }
        updateLocation();
    }
    @Override
    public int getRandomX() {
        randomIdx = GameManager.rand.nextInt(getSpawnPosX().size());
        setMovementInt(randomIdx);
        return getSpawnPosX().get(randomIdx);
    }
    private ImageIcon getRandomImg() {
        randomIdx = GameManager.rand.nextInt(carImgs.length);
        return carImgs[randomIdx];
    }
    public boolean onScreen() {
        if (getPosY() >= 0 && getPosY() < GamePanel.height) {
            return true;
        }
        return false;
    }
    public void detectOtherObstacle(RoadHole r) {
        if (getBounds().intersects(r.getBounds()) && !obstacleAhead && onScreen()) {
            obstacleAhead = true;
            timer.start();
            if (r.getType() == 1) {
                // jika bertemu jeglongan besar
                // dan mobil berada di pinggir jalan
                // maka mobil slowdown
                if (getMovementInt() == 0 || getMovementInt() == 3) {
                    speed = GameManager.OBS_SPEED;
                }
                else if (getMovementInt() == 1) {
                    moveRight();
                }
                else {
                    moveLeft();
                }
            }
            else {
                if (getMovementInt() == 0) {
                    moveRight();
                }
                else if (getMovementInt() == 1 || getMovementInt() == 2) {
                    int x = GameManager.rand.nextInt(2);
                    if (x == 0) {
                        moveLeft();
                    }
                    else {
                        moveRight();
                    }
                }
                else {
                    moveLeft();
                }
            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        obstacleAhead = false;
    }
    
}
