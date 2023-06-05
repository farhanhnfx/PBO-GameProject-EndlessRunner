import javax.swing.*;
import java.util.Random;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PowerUp extends JLabel implements ICollision{
    protected ImageIcon img;
    protected ImageIcon img_exit;
    private int point; 
    private int posX;
    private int posY;
    private int[] availablePosX = {100, 176, 270, 346};
    private Random random;
    private int randIdxPos;
    private int initPosY;
    protected int width;
    protected int height;


    
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
        img_exit = new ImageIcon("src/assets/PowerUp-Exit.gif");
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
        return availablePosX[randIdxPos];
    }

    // Display Effect When hit By Player
    @Override
    public void checkCollision(Player player, CollisionEffect fx) {
        if (!player.isCollided() && player.getBounds().intersects(getBounds())) {
            player.increaseHealth(point);
            // System.out.println("jeglong!");
            fx.displayHealedScreen();
            tempExitAnimation();
        }
        
    }


    // Method to move same as roadmark
    public void addPosY() {
        this.posY += 8;
        if (this.posY > GamePanel.height - initPosY) {
            this.posX = getRandomX();
            this.posY = initPosY;
        }
        setLocation(posX, posY);
    }

    public void tempExitAnimation(){
        Timer timer = new Timer(3000, new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                setVisible(true);
                // setIcon(img);
            }
        });
        timer.setRepeats(false);
        timer.start();
        setVisible(false);
        // setIcon(img_exit);
        // setSize(img_exit.getIconWidth(), img_exit.getIconHeight());
    }

    
}
