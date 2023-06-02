import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class NonPlayableCar extends Obstacle implements ICollision, ActionListener {
    private int posX;
    private int posY;
    private int[] availablePosX = {100, 176, 270, 346};
    private Random random;
    private int randIdx;
    private int initPosY;
    private int movementInt;
    private boolean obstacleAhead;
    private Timer timer = new Timer(500, this);
    private String[] imgUrls = {"src/assets/Car_Red.png", 
                                "src/assets/Car_Blue.png", "src/assets/Car_Yellow.png"};
    private JLabel label;

    public NonPlayableCar() {
        super(7);
        //TODO Auto-generated constructor stub
        // img = new ImageIcon("src/assets/Car_Red_Opposite.png");
        width = 64;
        height = 120;
        // initPosY = 1000; // if from bottom to up
        // posY = 1000;
        initPosY = -500;
        posY = -500;
        random = new Random();
        posX = getRandomX();
        img = getRandomImg();
        obstacleAhead = false;
        
        label = new JLabel();
        label.setBounds(0, 0, width, height);
        label.setBackground(Color.RED);
        add(label);
        
        setIcon(img);
        setBounds(posX, 100, width, height);
        timer.setRepeats(false);
    }
    
    public void addPosY() {
        // this.posY -= 6; // if from bottom to up
        this.posY += 12; // if from up to bottom
        // if (this.posY < -height) { // < -height if from bottom to up
        if (this.posY > GamePanel.height) {
            this.posX = getRandomX();
            this.posY = initPosY;
            setIcon(getRandomImg());
        }
        setLocation(posX, posY);
    }
    private int getRandomX() {
        randIdx = random.nextInt(availablePosX.length);
        movementInt = randIdx;
        return availablePosX[randIdx];
    }
    private ImageIcon getRandomImg() {
        randIdx = random.nextInt(imgUrls.length);
        return new ImageIcon(imgUrls[randIdx]);
    }
    @Override
    protected void paintComponent(Graphics g) {
        // TODO Auto-generated method stub
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawRect(0, 0, width, height);
    }

    public boolean canMove() {
        if (movementInt >= 0 && movementInt <= 3) {
            return true;
        }
        return false;
    }
    public void moveRight() {
        if (movementInt < 3) {
            movementInt++;
        }
        if (canMove()) {
            posX = availablePosX[movementInt];
        }
        setLocation(posX, posY);
    }
    public void moveLeft() {
        if (movementInt > 0) {
            movementInt--;
        }
        if (canMove()) {
            posX = availablePosX[movementInt];
        }
        setLocation(posX, posY);
    }
    public void detectOtherObstacle(Obstacle o) {
        if (getBounds().intersects(o.getBounds()) && !obstacleAhead) {
            obstacleAhead = true;
            timer.start();
            if (movementInt == 3) {
                movementInt--;
            }
            else if (movementInt == 0) {
                movementInt++;
            }
            else if (movementInt == 2) {
                movementInt++;
            }
            else if (movementInt == 1) {
                movementInt++;
            }
            System.out.println("Obstacle Detected Ahead! [CODE: " + movementInt + "]");
            posX = availablePosX[movementInt];
            posY += height/4;
            setLocation(posX, posY);
        }
    }
    @Override
    public void checkCollision(Player p, CollisionEffect fx) {
        // TODO Auto-generated method stub
        if (!p.isCollided() && p.getBounds().intersects(getBounds())) {
            p.decreaseHealth(damage);
            // System.out.println("jeglong!");
            fx.displayDamageScreen();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        obstacleAhead = false;
    }
    
}
