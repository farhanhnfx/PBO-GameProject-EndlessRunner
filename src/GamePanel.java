import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class GamePanel extends JFrame {
    public final static int width = 512;    // lebar layar
    public final static int height = 640;   // tinggi layar
    private JLabel bg;
    private JPanel mainPanel;
    private Environment env;

    private JLabel countdownLabel;
    private int countdownValue = 4;
    private Timer countdownTimer;
    private JButton startButton;

    public GamePanel() {
        setTitle("Lampung: Discover the best road");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);

        GameManager gm = new GameManager();

        ImageIcon bgTitle = new ImageIcon("src/assets/title.png");
        JLabel labelTitle = new JLabel(bgTitle);
        labelTitle.setBounds(77, 107, 359, 309);
        add(labelTitle);

        ImageIcon bgImage = new ImageIcon("src/assets/background.jpg");
        bg = new JLabel(bgImage);
        bg.setBounds(0, 0, 512, 640);
        add(bg);

        mainPanel = new JPanel();
        mainPanel.setOpaque(false);
        mainPanel.setBounds(0, 0, 512, 640);
        mainPanel.setLayout(null);
        bg.add(mainPanel);

        startButton = new JButton();
        startButton.setBounds(129, 480, 255, 62);
        startButton.setText("Start The Game");
        startButton.setForeground(Color.white);
        startButton.setBackground(Color.green);
        startButton.setFont(new Font("Arial", Font.BOLD, 25));
        startButton.setBorder(null);
        startButton.setFocusPainted(false);
        startButton.setOpaque(true);
        mainPanel.add(startButton);
        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startButton.setBounds(0, 0, 0, 0);
                labelTitle.setVisible(false);
                startCountdown();
            }
        });

        countdownLabel = new JLabel();
        countdownLabel.setBounds(0, 250, width, 100);
        countdownLabel.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 90));
        countdownLabel.setForeground(new Color(253, 187, 60));
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(countdownLabel);

        setVisible(true);
    }

    private void startCountdown() {
        countdownTimer = new Timer(1250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownValue--;
                countdownLabel.setText(String.valueOf(countdownValue));
                if (countdownValue < 0) {
                    countdownTimer.stop();
                    startGame();
                } else if (countdownValue == 0) {
                    countdownLabel.setText("GO!");
                }
            }
        });
        countdownTimer.start();
    }

    private void startGame() {
        env = new Environment();
        env.setSize(width, height);
        env.setVisible(true);
        add(env);

        bg.setVisible(false);
    }
}
