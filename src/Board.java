import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Board extends JLabel {
    private ImageIcon img;
    private JLabel scoreLabel;
    private HealthBar healthBar;

    public Board() {
        img = ResourceManager.BOARD_BG;
        setBounds(16, 16, 144, 112);
        setIcon(img);

        healthBar = new HealthBar();
        add(healthBar);

        displayScore();
        engineImg();
        engineText();


        
        scoreLabel = new JLabel("0"); // Integer.toString(9999)
        scoreLabel.setBounds(16, 26, 112, 30);
        scoreLabel.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 20));
        scoreLabel.setForeground(Color.WHITE);
        add(scoreLabel);
    }
    public HealthBar getHealthBar() {
        return healthBar;
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // healthDisplay(g);
    }

    public void displayScore() {        
        JLabel font = new JLabel("Score");
        font.setBounds(16, 13, 29, 15);
        font.setFont(ResourceManager.POPPINS_LIGHT.deriveFont(Font.PLAIN, 10));
        font.setForeground(Color.WHITE);
        add(font);
    }

    public void score() {
        JLabel font = new JLabel("0"); // Integer.toString(9999)
        font.setBounds(16, 26, 112, 30);
        font.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 20));
        font.setForeground(Color.WHITE);
        add(font);
    }
    public void updateHealth(int health) {
        for (int i = 0; i < health; i++) {
            healthBar.getBars().get(i).setVisible(true);
        }
        for (int i = health; i < 7; i++) {
            healthBar.getBars().get(i).setVisible(false);
        }
    }
    public void updateScore(int score) {
        scoreLabel.setText(Integer.toString(score));
    }

    public void engineImg() {
        JLabel img = new JLabel(ResourceManager.ENGINE_IMG);
        img.setBounds(18, 61, 12, 9);
        add(img);
    }

    public void engineText() {
        JLabel font = new JLabel("Engine");
        font.setBounds(35, 59, 33, 15);
        font.setFont(ResourceManager.POPPINS_LIGHT.deriveFont(Font.PLAIN, 10));
        font.setForeground(Color.WHITE);
        add(font);
    }
}
