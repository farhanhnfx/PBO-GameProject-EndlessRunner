import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JFrame {
    public final static int width = 512;    // lebar layar
    public final static int height = 640;   // tinggi layar
    private JLabel bg;
    private JPanel mainPanel;
    // private Environment env;

    private JLabel countdownLabel;
    private int countdownValue;
    private Timer countdownTimer;
    private JButton startButton;
    private JButton retryButton;
    public static JPanel gameOverPanel;
    public static JLabel finalScoreText;
    public static JLabel yourScore;
    public static JLabel gameOver;
    private GameManager gm;

    public GamePanel() {
        setTitle("Lampung: Discover the best road");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);

        gm = new GameManager();

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
        mainPanel.setBounds(0, 0, width, height);
        mainPanel.setLayout(null);
        bg.add(mainPanel);

        gameOverPanel = new JPanel();
        gameOverPanel.setBounds(0, 0, width, height);
        gameOverPanel.setBackground(new Color(0, 0, 0, 230));
        gameOverPanel.setLayout(null);
        gameOverPanel.setVisible(false);

        JLabel goText = new JLabel();
        goText.setBackground(Color.RED);
        goText.setBounds(65, 192, 400, 92);
        System.out.println(goText.getBounds());
        gameOverPanel.add(goText);

        gameOver = new JLabel("GAME OVER!");
        gameOver.setHorizontalAlignment(SwingConstants.CENTER);
        gameOver.setForeground(new Color(255, 255, 255));
        gameOver.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 48));
        gameOver.setBounds(97, 202, 302, 72);
        gameOverPanel.add(gameOver);


        yourScore = new JLabel("YOUR FINAL SCORE");
        yourScore.setHorizontalAlignment(SwingConstants.CENTER);
        yourScore.setForeground(new Color(255, 255, 255));
        yourScore.setFont(ResourceManager.POPPINS_LIGHT.deriveFont(Font.PLAIN, 24));
        yourScore.setBounds(150, 300, 214, 36);
        gameOverPanel.add(yourScore);

        finalScoreText = new JLabel("0");
        finalScoreText.setHorizontalAlignment(SwingConstants.CENTER);
        finalScoreText.setForeground(new Color(253, 187, 60));
        finalScoreText.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 90));
        finalScoreText.setBounds(156, 329, 200, 135);
        gameOverPanel.add(finalScoreText);

        add(gameOverPanel);
        retryButton = new JButton();
        retryButton.setBounds(167, 500, 179, 62);
        retryButton.setText("Try Again");
        retryButton.setForeground(Color.white);
        retryButton.setBackground(Color.green);
        retryButton.setFont(new Font("Arial", Font.BOLD, 25));
        retryButton.setBorder(null);
        retryButton.setFocusPainted(false);
        retryButton.setOpaque(true);
        gameOverPanel.add(retryButton);
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retryButton.setVisible(false);
                labelTitle.setVisible(false);
                GamePanel.gameOverPanel.setVisible(false);
                startCountdown(true);
            }
        });

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
                startCountdown(false);
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

    private void startCountdown(boolean restart) {
        countdownValue = 3;  // Ubah nilai awal countdown menjadi 3
        countdownLabel.setText(String.valueOf(countdownValue));  // Tampilkan angka 3 pada label countdown
        bg.setVisible(true);
        
        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownValue--;
                if (countdownValue < 0) {
                    countdownTimer.stop();
                    if (!restart) {
                        startGame();
                    } else {
                        restartGame();
                    }
                } else if(countdownValue == 0){
                    countdownLabel.setText("GO!");
                }
                else {
                    countdownLabel.setText(String.valueOf(countdownValue));
                }
            }
        });
        countdownTimer.start();
    }
    

    private void startGame() {
        gm.start();
        add(GameManager.env);

        bg.setVisible(false);
    }

    private void restartGame() {
        retryButton.setVisible(true);
        gm.restart();

        bg.setVisible(false);
    }
}
