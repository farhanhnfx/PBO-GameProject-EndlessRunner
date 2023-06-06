import javax.swing.*;
import java.util.Random;

public class PowerUp extends JLabel implements ICollision{
    private ImageIcon img;
    private int point; 
    private int posX;
    private int posY;
    private int[] availablePosX = {100, 176, 270, 346};
    private Random random;
    private int randIdxPos;
    private int initPosY;
    private int width;
    private int height;


    
    //Same Logic as RoadHole but have the movement OpsCar 
    public PowerUp(int posY) {
        this.point = 1;
        random = new Random();
        this.posX = getRandomX();
        this.initPosY = posY;
        this.posY = initPosY;
        img = new ImageIcon("src/assets/PowerUp.png");
        width = img.getIconWidth();
        height = img.getIconHeight();
        setIcon(img);
        setBounds(posX, initPosY, width, height);
    }

    // Getter For Posx
    public int getPosX() {
        return posX;
    }

    // Randomize spawning location by x-axis
    private int getRandomX() {
        randIdxPos = random.nextInt(availablePosX.length);
        setVisible(true);
        return availablePosX[randIdxPos];
    }

    // Display Effect When hit By Player
    @Override
    public void checkCollision(Player player, CollisionEffect fx) {
        if (!player.isCollided && player.getBounds().intersects(getBounds())) {
            player.increaseHealth(point);
            // System.out.println("jeglong!");
            fx.displayHealedScreen();
            setVisible(false);
        }
    }


    // Method to move same as roadmark
    public void moveDown() {
        this.posY += GameManager.OBS_SPEED;
        if (this.posY > GamePanel.height - initPosY) {
            this.posX = getRandomX();
            this.posY = initPosY;
        }
        setLocation(posX, posY);
    }
    
}
