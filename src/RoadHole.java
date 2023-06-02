import javax.swing.*;
import java.util.Random;

public class RoadHole extends Obstacle implements ICollision {
    private int posX;
    private int posY;
    private int[] availablePosX = {120, 278};
    private Random random;
    private int randIdxPos;
    private int initPosY;

    public RoadHole(int posY, int type) {
        super(1);
        random = new Random();
        this.posX = getRandomX();
        this.initPosY = posY;
        // this.initPosY = -100;
        this.posY = initPosY;
        // System.out.println(posX + ", " + this.posY);
        if (type == 1) {
            img = new ImageIcon("src/assets/Obstacle1_Small.png");
        }
        else {
            img = new ImageIcon("src/assets/Obstacle2.png");
        }
        width = img.getIconWidth();
        height = img.getIconHeight();
        setIcon(img);
        setBounds(posX, initPosY, width, height);
    }
    public int getPosX() {
        return posX;
    }
    public void addPosY() {
        this.posY += 8;
        if (this.posY > GamePanel.height - initPosY) {
            this.posX = getRandomX();
            this.posY = initPosY;
            // System.out.println(posY);
        }
        setLocation(posX, posY);
    }
    private int getRandomX() {
        randIdxPos = random.nextInt(availablePosX.length);
        return availablePosX[randIdxPos];
    }
    // @Override
    // public void checkCollision(Player player) {
    //     if (!player.isCollided() && player.getBounds().intersects(getBounds())) {
    //         player.decreaseHealth(damage);
    //         System.out.println("jeglong!");
    //     }
    // }
    @Override
    public void checkCollision(Player player, CollisionEffect fx) {
        if (!player.isCollided() && player.getBounds().intersects(getBounds())) {
            player.decreaseHealth(damage);
            // System.out.println("jeglong!");
            fx.displayDamageScreen();
        }
    }



    
}
