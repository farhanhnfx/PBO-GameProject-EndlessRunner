package Gameplay;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

import Board.Board;
import GameObjects.PlayerCar;

public class GameManager implements ActionListener {
    public static int gameScore;
    public static boolean isGameOver;
    public static PlayerCar player;
    public static Board board;
    public static Random rand;
    public static Environment env;
    public static final int NPC_SPEED = 12; // default: 12
    public static final int OBS_SPEED = 8; //  default: 8
    public static final int ENV_DELAY = 15; //  default: 15
    private Timer timer;

    public GameManager() {
        rand = new Random();
        board = new Board();
        player = new PlayerCar();
        timer = new Timer(500, this);
    }
    
    public void start() {
        gameScore = 0;
        isGameOver = false;
        env = new Environment();
        env.setSize(GamePanel.width, GamePanel.height);
        env.setVisible(true);
        timer.start();
    }
    public void restart() {
        gameScore = 0;
        isGameOver = false;
        timer.start();
        player.spawn();
        board.updateScore(gameScore);
        env.getRh().spawn();
        env.getRh2().spawn();
        env.getNpCar().spawn();
        env.startEnv();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gameScore += 5;
        board.updateScore(gameScore);
        // env.runActivities();
        if (isGameOver) {
            // System.out.println("isGameOver: " + isGameOver);
            // GamePanel.finalScoreText.setText(Integer.toString(gameScore));
            // GamePanel.gameOverPanel.setVisible(true);
            timer.stop();
            // if (gameScore > highScore) {
            //     highScore = gameScore;
            // }
        }
    }
}
