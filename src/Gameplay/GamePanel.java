package Gameplay;

import javax.sound.sampled.Clip;
import javax.swing.*;

import Resources.ResourceManager;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GamePanel extends JFrame implements ActionListener {
    public final static int width = 512;    // lebar layar
    public final static int height = 640;   // tinggi layar
    private JLabel bg;
    private JPanel mainPanel;
    // private Environment env;
    private Clip backsongClip;


    private JLabel countdownLabel;
    private int countdownValue;
    private Timer countdownTimer;
    private JButton startButton;
    private JButton retryButton;
    private JPanel gameOverPanel;
    private JLabel finalScoreText;
    private JLabel yourScore;
    private JLabel highScoreText;
    private JLabel highScoreNum;
    private JLabel gameOverText;
    private GameManager gm;
    private Timer timer;
    private final Color btnColor = new Color(29, 154, 34);

    public GamePanel() {
        setTitle("Lampung: Discover the best road");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);

        gm = new GameManager();

        ImageIcon bgTitle = ResourceManager.GAME_TITLE_IMG;
        JLabel labelTitle = new JLabel(bgTitle);
        labelTitle.setLayout(null);
        JLabel titleDesc = new JLabel("Discover the best road!");
        titleDesc.setHorizontalAlignment(SwingConstants.CENTER);
        titleDesc.setForeground(new Color(255, 255, 255));
        titleDesc.setFont(ResourceManager.POPPINS_LIGHT.deriveFont(Font.PLAIN, 24));
        titleDesc.setBounds(30, 265, 302, 72);
        labelTitle.setBounds(77, 70, 359, 320);
        labelTitle.add(titleDesc);
        add(labelTitle);

        backsongClip = ResourceManager.backgroundMusic;
        backsongClip.loop(Clip.LOOP_CONTINUOUSLY);
        backsongClip.start();

        ImageIcon bgImage = ResourceManager.START_BG;
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

        gameOverText = new JLabel("GAME OVER!");
        gameOverText.setHorizontalAlignment(SwingConstants.CENTER);
        gameOverText.setForeground(new Color(255, 255, 255));
        gameOverText.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 48));
        gameOverText.setBounds(97, 142, 302, 72);
        gameOverPanel.add(gameOverText);

        JLabel goTextBg = new JLabel();
        goTextBg.setBackground(Color.RED);
        goTextBg.setOpaque(true);
        goTextBg.setBounds(48, 132, 416, 92);
        gameOverPanel.add(goTextBg);

        yourScore = new JLabel("YOUR FINAL SCORE");
        yourScore.setHorizontalAlignment(SwingConstants.CENTER);
        yourScore.setForeground(new Color(255, 255, 255));
        yourScore.setFont(ResourceManager.POPPINS_LIGHT.deriveFont(Font.PLAIN, 24));
        yourScore.setBounds(0, 240, width, 36);
        gameOverPanel.add(yourScore);

        highScoreText = new JLabel("HIGH SCORE");
        highScoreText.setHorizontalAlignment(SwingConstants.CENTER);
        highScoreText.setForeground(new Color(255, 255, 255));
        highScoreText.setFont(ResourceManager.POPPINS_LIGHT.deriveFont(Font.PLAIN, 20));
        highScoreText.setBounds(0, 368, width, 36);
        gameOverPanel.add(highScoreText);

        finalScoreText = new JLabel("0");
        finalScoreText.setHorizontalAlignment(SwingConstants.CENTER);
        finalScoreText.setForeground(new Color(253, 187, 60));
        finalScoreText.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 90));
        finalScoreText.setBounds(0, 260, width, 135);
        gameOverPanel.add(finalScoreText);

        highScoreNum = new JLabel("0");
        highScoreNum.setHorizontalAlignment(SwingConstants.CENTER);
        highScoreNum.setForeground(new Color(253, 187, 60));
        highScoreNum.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 30));
        highScoreNum.setBounds(0, 355, width, 135);
        gameOverPanel.add(highScoreNum);

        add(gameOverPanel);
        retryButton = new JButton();
        retryButton.setBounds(167, 450, 179, 62);
        retryButton.setText("Try Again");
        retryButton.setForeground(Color.white);
        retryButton.setBackground(btnColor);
        retryButton.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 24));
        retryButton.setBorder(null);
        retryButton.setFocusPainted(false);
        retryButton.setOpaque(true);
        gameOverPanel.add(retryButton);
        retryButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                retryButton.setVisible(false);
                labelTitle.setVisible(false);
                gameOverPanel.setVisible(false);
                startCountdown(true);
            }
        });

        startButton = new JButton();
        startButton.setBounds(128, 450, 255, 62);
        startButton.setText("Start The Game");
        startButton.setForeground(Color.white);
        startButton.setBackground(btnColor);
        startButton.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 24));
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

        timer = new Timer(1500, this);

        countdownLabel = new JLabel();
        countdownLabel.setBounds(0, 250, width, 100);
        countdownLabel.setFont(ResourceManager.POPPINS_BOLD.deriveFont(Font.PLAIN, 90));
        countdownLabel.setForeground(new Color(253, 187, 60));
        countdownLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mainPanel.add(countdownLabel);


        setVisible(true);
    }

    private void startCountdown(boolean restart) {
        countdownValue = 3;
        countdownLabel.setText(String.valueOf(countdownValue));
        bg.setVisible(true);

        countdownTimer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                countdownValue--;
                if (countdownValue > 0) {
                    countdownLabel.setText(String.valueOf(countdownValue));
                } else if (countdownValue == 0) {
                    countdownLabel.setText("GO!");
                } else {
                    countdownTimer.stop();
                    timer.start();
                    if (!restart) {
                        startGame();
                    } else {
                        restartGame();
                    }
                }
            }
        });
        countdownTimer.start();
        ResourceManager.countdownSound.setFramePosition(0); 
        ResourceManager.countdownSound.start();
    }

    private void startGame() {
        gm.start();
        add(GameManager.env);

        bg.setVisible(false);
    }

    private void restartGame() {
        retryButton.setVisible(true);
        gm.restart();
        backsongClip.setFramePosition(0);
        backsongClip.start();

        bg.setVisible(false);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (GameManager.isGameOver) {
            finalScoreText.setText(Integer.toString(GameManager.gameScore));
            highScoreNum.setText(Integer.toString(GameManager.highScore));
            gameOverPanel.setVisible(true);
            timer.stop();
            backsongClip.stop();
            ResourceManager.gameOverSound.setFramePosition(0);
            ResourceManager.gameOverSound.start();
        }
    }
}
