package GameObjects;
import java.util.ArrayList;

import javax.swing.*;

import Gameplay.GameManager;

public abstract class ColliderObject extends JLabel {
    protected int width;
    protected int height;
    protected ImageIcon img;
    private int posX;
    private int posY = 448;
    private ArrayList<Integer> spawnPosX; // = {100, 176, 270, 346};
    private int movementInt;
    public boolean isCollided;

    public ColliderObject() {
        spawnPosX = new ArrayList<>();
        setVisible(true);
    }
    
    public int getPosX() {
        return posX;
    }
    public void setPosX(int posX) {
        this.posX = posX;
    }
    public void setPosY(int posY) {
        this.posY = posY;
    }
    public void setMovementInt(int movementInt) {
        this.movementInt = movementInt;
    }
    public int getMovementInt() {
        return movementInt;
    }
    public int getPosY() {
        return posY;
    }
    public ArrayList<Integer> getSpawnPosX() {
        return spawnPosX;
    }
    public void addSpawnPosX(int spawnPos) {
        this.spawnPosX.add(spawnPos);
    }
    public void updateLocation() {
        setLocation(posX, posY);
    }
    public boolean canMove() {
        if (movementInt >= 0 && movementInt <= 3 && !GameManager.isGameOver) {
            return true;
        }
        return false;
    }
    public void moveRight() {
        if (movementInt < 3) {
            movementInt++;
        }
        if (canMove()) {
            posX = spawnPosX.get(movementInt);
        }
        updateLocation();
    }
    public void moveLeft() {
        if (movementInt > 0) {
            movementInt--;
        }
        if (canMove()) {
            posX = spawnPosX.get(movementInt);
        }
        updateLocation();
    }
    public void setImg(ImageIcon img) {
        setIcon(img);
        width = img.getIconWidth();
        height = img.getIconHeight();
        setBounds(posX, posY, width, height);
    }
    
    public abstract void spawn();
}
