public class RoadHole extends Obstacle {
    private int randIdxPos;
    private int initPosY;
    private int type;

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
    public void moveDown() {
        setPosY(getPosY() + GameManager.OBS_SPEED);
        if (getPosY()> GamePanel.height) {
            spawn();
        }
        updateLocation();
    }
    private int getRandomX() {
        randIdxPos = GameManager.rand.nextInt(getSpawnPosX().size());
        return getSpawnPosX().get(randIdxPos);
    }

}
