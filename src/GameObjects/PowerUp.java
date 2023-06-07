package GameObjects;

import Gameplay.CollisionEffect;
import Gameplay.GameManager;
import Gameplay.GamePanel;
import Resources.ResourceManager;

public class PowerUp extends MovingObject implements IMovementY {
    private int point;
    
    //Same Logic as RoadHole but have the movement OpsCar 
    public PowerUp(int posY) {
        addSpawnPosX(108);
        addSpawnPosX(176);
        addSpawnPosX(270);
        addSpawnPosX(346);
        this.point = 1;
        setPosX(getRandomX());
        this.initPosY = posY;
        setPosY(initPosY);
        setImg(ResourceManager.POWERUP_IMG);
    }

    // Randomize spawning location by x-axis
    public int getRandomX() {
        randomIdx = GameManager.rand.nextInt(getSpawnPosX().size());
        setVisible(true);
        return getSpawnPosX().get(randomIdx);
    }

    // Display Effect When hit By Player
    @Override
    public void checkCollision(PlayerCar player, CollisionEffect fx) {
        if (!player.isCollided && player.getBounds().intersects(getBounds())) {
            player.increaseHealth(point);
            // System.out.println("jeglong!");
            fx.displayHealedScreen();
            setVisible(false);
        }
    }
    @Override
    public void moveDown() {
        setPosY(getPosY() + GameManager.OBS_SPEED);
        if (getPosY()> GamePanel.height) {
            spawn();
        }
        updateLocation();
    }

    @Override
    public void spawn() {
        setPosX(getRandomX());
        setPosY(initPosY);
    }
    
}
