import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.Timer;

public class GameManager implements ActionListener {
    public static int gameScore;
    public static boolean isGameOver;
    public static Player player;
    public static Board board;
    public static Random rand;
    public static Environment env;
    private Timer timer;

    public GameManager() {
        rand = new Random();
        board = new Board();
        player = new Player();
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
        env.rh.spawn();
        env.rh2.spawn();
        env.npCar.spawn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        gameScore += 5;
        board.updateScore(gameScore);
        // System.out.println("SCORE: " + gameScore);
        if (isGameOver) {
            // System.out.println("isGameOver: " + isGameOver);
            // GamePanel.finalScoreText.setText(Integer.toString(gameScore));
            // GamePanel.gameOverPanel.setVisible(true);
            timer.stop();
        }
    }
}
