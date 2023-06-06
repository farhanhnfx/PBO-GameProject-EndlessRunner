import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

public class NonPlayableCar extends ColliderObject implements ICollision, ActionListener {
    private int posX;
    private int posY;
    private int[] availablePosX = {100, 176, 270, 346};
    private int randIdx;
    private int initPosY;
    private int movementInt;
    private boolean obstacleAhead;
    private Timer timer = new Timer(500, this);
    private final ImageIcon[] carImgs = ResourceManager.NPC_CARS;
    private JLabel label;

    public NonPlayableCar() {
        super(Player.MAX_HEALTH);
        // img = new ImageIcon("src/assets/Car_Red_Opposite.png");
        width = 64;
        height = 120;
        // initPosY = 1000; // if from bottom to up
        // posY = 1000;
        initPosY = -500;
        
        label = new JLabel();
        label.setBounds(0, 0, width, height);
        label.setBackground(Color.RED);
        add(label);
        
        spawn();
        timer.setRepeats(false);
    }

    public void spawn() {
        posY = initPosY;
        posX = getRandomX();
        obstacleAhead = false;
        setBounds(posX, posY, width, height);
        setIcon(getRandomImg());
    }
    public void moveDown() {
        // this.posY -= 6; // if from bottom to up
        this.posY += GameManager.NPC_SPEED; // if from up to bottom
        // if (this.posY < -height) { // < -height if from bottom to up
        if (this.posY > GamePanel.height) {
            this.posX = getRandomX();
            this.posY = initPosY;
            setIcon(getRandomImg());
        }
        setLocation(posX, posY);
    }
    private int getRandomX() {
        randIdx = GameManager.rand.nextInt(availablePosX.length);
        movementInt = randIdx;
        return availablePosX[randIdx];
    }
    private ImageIcon getRandomImg() {
        randIdx = GameManager.rand.nextInt(carImgs.length);
        return carImgs[randIdx];
    }
    // @Override
    // protected void paintComponent(Graphics g) {
    //     super.paintComponent(g);
    //     g.setColor(Color.RED);
    //     g.drawRect(0, 0, width, height);
    // }

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
    public void detectOtherObstacle(ColliderObject o) {
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
            // System.out.println("Obstacle Detected Ahead! [CODE: " + movementInt + "]");
            posX = availablePosX[movementInt];
            posY += height/4;
            setLocation(posX, posY);
        }
    }
    @Override
    public void checkCollision(Player p, CollisionEffect fx) {
        if (!p.isCollided && p.getBounds().intersects(getBounds())) {
            p.decreaseHealth(damage);
            fx.displayDamageScreen();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        obstacleAhead = false;
    }
    
}
