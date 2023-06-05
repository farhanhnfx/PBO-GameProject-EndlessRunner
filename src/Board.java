import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Board extends JLabel {
    private ImageIcon img;
    public int score = 0;
    public JLabel boardLabel;
    private JLabel scoreLabel;
    public ArrayList<Color> colors;
    private HealthBar healthBar;

    public Board() {
        img = new ImageIcon("src/assets/BgBoard.png");
        setBounds(16, 16, 144, 112);
        setIcon(img);

        healthBar = new HealthBar();
        add(healthBar);

        displayScore();
        // score();
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
    public void decreaseHealth(int health) {
        
    }

    public void engineImg() {
        JLabel img = new JLabel(new ImageIcon("src/assets/engine.png"));
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

    public void healthDisplay(Graphics g) {
        int width = 112;
        int height = 16;

        int numColors = 7;

        int colorWidth = width / numColors;

        // Daftar warna
        // Color[] colors = { color1, color2, color3, color4, color5, color6, color7 };

        for (int i = 0; i < numColors; i++) {
            int x = i * colorWidth;
            int y = 0;

            g.setColor(colors.get(i));
            g.fillRect(x+16, y+78, colorWidth, height);
        }
    }
}
