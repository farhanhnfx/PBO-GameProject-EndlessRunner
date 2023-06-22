package GameObjects;

import Gameplay.GameManager;
import Gameplay.GamePanel;
import Resources.ResourceManager;

public class RoadHole extends Obstacle {
    private int type;

    public RoadHole(int posY) {
        this.type = 1;
        addSpawnPosX(120);
        addSpawnPosX(278);
        super.setDamage(1);
        img = ResourceManager.ROADHOLE_IMGS[0];
        setImg(img);
        this.initPosY = posY;
        spawn();
    }

    public RoadHole(int posY, int type) {
        this.type = type;
        addSpawnPosX(120);
        addSpawnPosX(278);
        super.setDamage(1);
        if (type == 1) {
            img = ResourceManager.ROADHOLE_IMGS[0];
        }
        else {
            img = ResourceManager.ROADHOLE_IMGS[1];
            addSpawnPosX(176);
            addSpawnPosX(346);
        }
        setImg(img);
        this.initPosY = posY;
        spawn();
    }
    public int getType() {
        return type;
    }
    public void spawn() {
        setPosX(getRandomX());
        setPosY(initPosY);
    }
    @Override
    public void moveDown() {
        setPosY(getPosY() + GameManager.OBS_SPEED);
        if (getPosY()> GamePanel.height) {
            spawn();
        }
        updateLocation();
    }
    public int getRandomX() {
        randomIdx = GameManager.rand.nextInt(getSpawnPosX().size());
        return getSpawnPosX().get(randomIdx);
    }

}
