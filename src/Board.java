import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Board extends Player {
    private ImageIcon img;
    public int score = 0;
    public JLabel boardLabel;
    Color color1;
    Color color2;
    Color color3;
    Color color4;
    Color color5;
    Color color6;
    Color color7;

    public Board() {
        color1 = new Color(223, 44, 58);
        color2 = new Color(223, 87, 44);
        color3 = new Color(223, 119, 44);
        color4 = new Color(223, 173, 44);
        color5 = new Color(198, 223, 44);
        color6 = new Color(144, 223, 44);
        color7 = new Color(32, 207, 49);

        img = new ImageIcon("src/assets/BgBoard.png");
        setBounds(16, 16, 144, 112);
        setIcon(img);

        displayScore();
        score();
        engineImg();
        engineText();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        healtDisplay(g);
    }

    public void displayScore() {
        JLabel font = new JLabel("Score");
        font.setBounds(16, 13, 29, 15);
        font.setFont(new Font("Poppins", Font.PLAIN, 10));
        font.setForeground(Color.WHITE);
        add(font);
    }

    public void score() {
        JLabel font = new JLabel("0");
        font.setBounds(16, 26, 112, 30);
        font.setFont(new Font("Poppins", Font.BOLD, 20));
        font.setForeground(Color.WHITE);
        add(font);
    }

    public void engineImg() {
        JLabel img = new JLabel(new ImageIcon("src/assets/engine.png"));
        img.setBounds(18, 61, 12, 9);
        add(img);
    }

    public void engineText() {
        JLabel font = new JLabel("Engine");
        font.setBounds(35, 59, 33, 15);
        font.setFont(new Font("Poppins", Font.PLAIN, 10));
        font.setForeground(Color.WHITE);
        add(font);
    }

    public void healtDisplay(Graphics g) {
        int width = 112;
        int height = 16;

        int numColors = 7;

        int colorWidth = width / numColors;

        // Daftar warna
        Color[] colors = { color1, color2, color3, color4, color5, color6, color7 };

        for (int i = 0; i < numColors; i++) {
            int x = i * colorWidth;
            int y = 0;

            g.setColor(colors[i]);
            g.fillRect(x+16, y+78, colorWidth, height);
        }
    }
}
