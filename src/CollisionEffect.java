import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CollisionEffect extends JPanel {

//  Atribute Screen CollisionEffect
    public final int collWidth = GamePanel.width;
    public final int collHeight = GamePanel.height;

    Color defaultScene;
    Color damagedScene;
    Color healedScene;





    // Create a JPanel to add the JLabel

    public CollisionEffect(){
        defaultScene = new Color(0,0,0,0);
        damagedScene = new Color(255,0,0,80);
        healedScene = new Color (0,255,0,80);
        setBounds(0,0,collWidth,collHeight);
        setBackground(defaultScene);
        setVisible(false);

    }

    public void displayDamageScreen(){
        setBackground(damagedScene);
        Timer timer = new Timer(300, new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
                setBackground(defaultScene);
            }
        });
        timer.setRepeats(false);
        timer.start();
        setVisible(true);
    }

}
