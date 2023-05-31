import javax.swing.*;
import java.awt.event.*;

public class GamePanel extends JFrame implements Runnable {
    public final static int width = 512;    // screen width
    public final static int height = 640;   // screen height
    private Thread gameThread;
    private Background bg;
    // private Player player;

    public GamePanel() {
        setTitle("Lampungzzzzzzz");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(null);

        bg = new Background();
        add(new ObstacleSpawner());
        add(bg);
        // startGame();

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
                        // Player.posX -= Player.width + 40;
                        bg.getPlayer().moveLeft();
                        break;
                    case KeyEvent.VK_RIGHT:
                        // Player.posX += Player.width + 40;
                        bg.getPlayer().moveRight();
                        break;
                }
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
        // JLabel jLabel = new JLabel("TEST");
        // jLabel.setBounds(280, 120, 500, 500);
        // bg.add(jLabel);
        // while (true) {
        //     // bg.getRh().checkCollision(player);
        //     // Rectangle playerBounds = player.getBounds();
        //     // Rectangle rhBounds = bg.getRh().getBounds();
        //     // System.out.println(playerBounds + ", " + rhBounds);
        //     // if (player.getPosX() == bg.getRh().getPosX()) {
        //     //     System.out.println(player.getPosX() + ", " + bg.getRh().getPosX());
        //     // }
        //     // if (playerBounds.intersects(rhBounds)) {
        //     //     System.out.println("jeglongan");
        //     // }
        //     // System.out.println(Player.posX + ", " + bg.getRh().getPosX());
        //     // if (bg.getRh().collision(player)) {
        //     //     System.out.println("jeglongan");
        //     // }
        // }
    }
    
}
