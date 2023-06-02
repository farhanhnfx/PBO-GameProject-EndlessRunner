import javax.swing.*;
import java.util.Random;

public class PowerUp extends Obstacle implements ICollision{
    protected int damage;
    protected ImageIcon img;
    private int point; 
    private int posX;
    private int posY;
    private int[] availablePosX = {100, 176, 270, 346};
    private Random random;
    private int randIdxPos;
    private int initPosY;

    

    public PowerUp() {
        super(1);
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

    private int getRandomX() {
        randIdxPos = random.nextInt(availablePosX.length);
        return availablePosX[randIdxPos];
    }


    @Override
    public void checkCollision(Player p, CollisionEffect fx) {
        // TODO Auto-generated method stub
        
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

    
}
