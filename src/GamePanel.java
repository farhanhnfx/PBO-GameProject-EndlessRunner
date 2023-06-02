import javax.swing.*;

public class GamePanel extends JFrame implements Runnable {
    public final static int width = 512;    // screen width
    public final static int height = 640;   // screen height
    private Thread gameThread;
    private Environment bg;
    // private Player player;

    public GamePanel() {
        setTitle("Lampung: Discover the best road");
        setSize(width, height);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(null);

        GameManager gm = new GameManager();
        bg = new Environment();
        // add(new ObstacleSpawner());
        add(bg);
        // startGame();

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
