import java.util.ArrayList;

public class RoadHole extends ColliderObject implements ICollision {
    private int posX;
    private int posY;
    private ArrayList<Integer> availablePosX;
    private int randIdxPos;
    private int initPosY;
    private int type;

    public RoadHole(int posY, int type) {
        super(1);
        this.type = type;
        availablePosX = new ArrayList<>();
        availablePosX.add(120);
        availablePosX.add(278);
        if (type == 1) {
            img = ResourceManager.ROADHOLE_IMGS[0];
        }
        else {
            img = ResourceManager.ROADHOLE_IMGS[1];
            availablePosX.add(176);
            availablePosX.add(346);
        }
        width = img.getIconWidth();
        height = img.getIconHeight();
        setIcon(img);
        this.initPosY = posY;
        spawn();
        // System.out.println(initPosY);
    }
    public int getPosX() {
        return posX;
    }
    public int getType() {
        return type;
    }
    public void spawn() {
        this.posX = getRandomX();
        // this.initPosY = posY;
        // this.posY = initPosY;
        setBounds(posX, initPosY, width, height);
    }
    public void moveDown() {
        this.posY += GameManager.OBS_SPEED;
        if (this.posY > GamePanel.height) {
            this.posX = getRandomX();
            this.posY = initPosY;
        }
        setLocation(posX, posY);
    }
    private int getRandomX() {
        randIdxPos = GameManager.rand.nextInt(availablePosX.size());
        return availablePosX.get(randIdxPos);
    }
    @Override
    public void checkCollision(Player player, CollisionEffect fx) {
        if (!player.isCollided && player.getBounds().intersects(getBounds())) {
            player.decreaseHealth(damage);
            // System.out.println("jeglong!");
            fx.displayDamageScreen();
        }
    }

}
