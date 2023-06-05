import javax.swing.*;

public class RoadHole extends ColliderObject implements ICollision {
    private int posX;
    private int posY;
    private int[] availablePosX = {120, 278};
    private int randIdxPos;
    private int initPosY;

    public RoadHole(int posY, int type) {
        super(1);
        if (type == 1) {
            img = new ImageIcon("src/assets/Obstacle1_Small.png");
        }
        else {
            img = new ImageIcon("src/assets/Obstacle2.png");
        }
        width = img.getIconWidth();
        height = img.getIconHeight();
        setIcon(img);
        this.initPosY = posY;
        spawn();
        System.out.println(initPosY);
    }
    public int getPosX() {
        return posX;
    }
    public void spawn() {
        this.posX = getRandomX();
        // this.initPosY = posY;
        // this.posY = initPosY;
        setBounds(posX, initPosY, width, height);
    }
    public void addPosY() {
        this.posY += 8;
        if (this.posY > GamePanel.height) {
            this.posX = getRandomX();
            this.posY = initPosY;
        }
        setLocation(posX, posY);
    }
    private int getRandomX() {
        randIdxPos = GameManager.rand.nextInt(availablePosX.length);
        return availablePosX[randIdxPos];
    }
    @Override
    public void checkCollision(Player player, CollisionEffect fx) {
        if (!player.isCollided() && player.getBounds().intersects(getBounds())) {
            player.decreaseHealth(damage);
            // System.out.println("jeglong!");
            fx.displayDamageScreen();
        }
    }
    
}
