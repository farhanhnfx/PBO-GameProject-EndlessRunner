import javax.swing.*;

public abstract class ColliderObject extends JLabel {
    protected int damage;
    protected ImageIcon img;
    protected final int posX = 100;
    protected int posY;
    protected int width;
    protected int height;
    
    public ColliderObject(int damage) {
        this.damage = damage;
    }
}
