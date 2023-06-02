import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Timer;

public class GameManager implements ActionListener {
    public static int gameScore;
    public static boolean isGameOver;
    public static Player player;
    private Timer timer;
    public static Board board;

    public GameManager() {
        board = new Board();
        player = new Player();
        gameScore = 0;
        isGameOver = false;
        timer = new Timer(500, this);
        timer.start();
    }
    
    public static void isOver(boolean isOver) {
        isGameOver = isOver;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        gameScore += 5;
        board.updateScore(gameScore);
        // System.out.println("SCORE: " + gameScore);
        if (isGameOver) {
            timer.stop();
        }
    }
}
