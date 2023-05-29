import javax.swing.*;
// import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GamePanel extends JFrame implements Runnable {
    public final static int width = 512;    // screen width
    public final static int height = 640;   // screen height
    private Thread gameThread;
    private Background bg;
    private Player player;
    private ArrayList<RoadMark> roadMarks;

    public GamePanel() {
        setTitle("Lampungzzzzzzz");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        bg = new Background();
        // player = new Player();
        // add(Player.carLabel);

        roadMarks = bg.getRoadMarks();
        add(bg);
        startGame();

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }

            @Override
            public void keyPressed(KeyEvent e) {
                // TODO Auto-generated method stub
                int keyCode = e.getKeyCode();
                switch (keyCode) {
                    case KeyEvent.VK_LEFT:
                        Player.posX -= Player.width + 40;
                        // Player.moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        Player.posX += Player.width + 40;
                        // Player.moveRight();
                        break;
                }
                Player.carLabel.setLocation(Player.posX, Player.posY);
            }

            @Override
            public void keyReleased(KeyEvent e) {
                // TODO Auto-generated method stub
                
            }
        });
        setVisible(true);
    }
    
    public void startGame() {
        gameThread = new Thread(this);
        gameThread.start(); // akan memanggil run
    }

    @Override
    public void run() {
        JLabel jLabel = new JLabel("TEST");
        jLabel.setBounds(280, 120, 500, 500);
        bg.add(jLabel);
        while (gameThread != null) {
            // for (RoadMark rm : roadMarks) {
            //     rm.setLocation(RoadMark.posX, rm.getPosY());
            //     rm.addPosY();
            // }
            // try {
            //     Thread.sleep(3); // 1 - 3?
            // } catch (InterruptedException e) {
            //     // TODO Auto-generated catch block
            //     e.printStackTrace();
            // }
        }
    }
    
}
