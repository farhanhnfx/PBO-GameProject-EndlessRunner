import javax.swing.*;

public abstract class Obstacle extends JLabel {
    protected int damage;
    protected ImageIcon img;
    protected final int posX = 100;
    protected int posY;
    protected int width;
    protected int height;
    
    public Obstacle(int damage) {
        this.damage = damage;
    }
}
