import javax.swing.*;
// import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JFrame implements Runnable {
    public final static int width = 512;    // screen width
    public final static int height = 640;   // screen height
    private Thread gameThread;
    private Background bg;
    private ArrayList<RoadMark> roadMarks;

    public GamePanel() {
        setTitle("Lampungzzzzzzz");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bg = new Background();
        roadMarks = bg.getRoadMarks();
        add(bg);
        startGame();

        setVisible(true);
    }
    
    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start(); // akan memanggil run
    }

    @Override
    public void run() {
        while (gameThread != null) {
            for (RoadMark rm : roadMarks) {
                rm.setBounds(RoadMark.posX, rm.getPosY(), RoadMark.width, RoadMark.height);
                rm.addPosY();
            }
            try {
                Thread.sleep(1); // 1 - 3?
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    
}
