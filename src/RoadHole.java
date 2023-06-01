import javax.swing.*;

public class RoadHole extends Obstacle implements ICollision {
    private int posX;
    private int posY;

    public RoadHole(int posY, int type) {
        super(1);
        this.posX = 96;
        this.posY = posY;
        if (type == 1) {
            img = new ImageIcon("src/assets/Obstacle1.png");
            width = 152;
            height = 149;
        }
        else {
            img = new ImageIcon("src/assets/Obstacle2.png");
            width = 133;
            height = 138;
        }
        setIcon(img);
        setBounds(posX, posY, 133, 138);
    }
    public int getPosX() {
        return posX;
    }
    public void addPosY() {
        this.posY += 10;
        if (this.posY == GamePanel.height) {
            this.posY = -90;
        }
        setLocation(posX, posY);
    }
    @Override
    public void checkCollision(Player player) {
        if (!player.isCollided() && player.getBounds().intersects(getBounds())) {
            player.decreaseHealth(damage);
            System.out.println("jeglong!");
        }
    }
    public void checkCollision(Player player,CollisionEffect fx) {
        if (!player.isCollided() && player.getBounds().intersects(getBounds())) {
            player.decreaseHealth(damage);
            System.out.println("jeglong!");
            fx.displayDamageScreen();
        }
    }



    
}
