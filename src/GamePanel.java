import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JFrame  {
    public final static int width = 512;    // screen width
    public final static int height = 640;   // screen height
    private JLabel bg;
    private JPanel mainPanel;
    private Environment env;

    public GamePanel() {
        setTitle("Lampung: Discover the best road");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);

        GameManager gm = new GameManager();
        
        ImageIcon bgImage = new ImageIcon("src/assets/background.jpg");
        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, 512, 640);
        add(bg);

        mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setBounds(0, 0, 512, 640);
        mainPanel.setLayout(null);
        bg.add(mainPanel);

        JButton startButton = new JButton();
        startButton.setBounds(129, 480, 255, 62);
        startButton.setText("Start The Game");
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.green);
        startButton.setFont(new java.awt.Font("Arial", Font.BOLD, 25));
        startButton.setBorder(null);
        startButton.setFocusPainted(false);
        startButton.setOpaque(true);
        mainPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startGame();
            }
        });
        setVisible(true);
    }
    
    private void startGame() {
        env = new Environment();
        env.setSize(width, height);
        env.setVisible(true);
        add(env);

        bg.setVisible(false);
    }
    
}
