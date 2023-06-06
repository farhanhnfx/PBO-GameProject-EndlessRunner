import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CollisionEffect extends JPanel {

//  Atribute Screen CollisionEffect
    private final int collWidth = GamePanel.width;
    private final int collHeight = GamePanel.height;

    private Color defaultScene;
    private Color damagedScene;
    private Color healedScene;
    private Timer timer;

    public CollisionEffect(){
        defaultScene = new Color(0,0,0,0);
        damagedScene = new Color(255,0,0,80);
        healedScene = new Color (0,255,0,80);
        setBounds(0, 0, collWidth, collHeight);
        setBackground(defaultScene);
        setVisible(false);
        timer = new Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                setBackground(defaultScene);
            }
        });
        timer.setRepeats(false);
    }

    public void displayDamageScreen(){
        setBackground(damagedScene);
        timer.start();
        setVisible(true);
    }
    public void displayHealedScreen(){
        setBackground(healedScene);
        timer.start();
        setVisible(true);
    }

}
