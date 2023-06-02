import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Environment extends JLayeredPane implements ActionListener {
    private final int roadWidth = 352;
    private final int sideWidth = 80;
    private final int height = GamePanel.height;
    private final Color sideColor = new Color(231, 200, 139); // jebul iso diatur transparencyne via alpha
    private final int markGap = 128;        // road mark vertical gap / def: 224
    private ArrayList<RoadMark> roadMarks;  // list of road marks
    private ImageIcon roadImg;
    private JLabel roadLabel;
    private Timer timer;
    private RoadHole rh;
    private RoadHole rh2;
    private Player player;
    private CollisionEffect fxScreen;
    private NonPlayableCar opsCar;
    // private Board board;

    public Environment() {
        roadImg = new ImageIcon("src/assets/Road.png");
        roadLabel = new JLabel(roadImg);
        roadLabel.setBounds(80, 0, 352, 640);
        setLayout(null);
        
        // board = new Board();
        // add(board);

        player = GameManager.player;
        fxScreen = new CollisionEffect();
        add(fxScreen);


        roadMarks = new ArrayList<>();
        roadMarks.add(new RoadMark(0));
        roadMarks.add(new RoadMark(roadMarks.get(0).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(1).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(2).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(3).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(4).getPosY() + markGap));
        rh = new RoadHole(-4000, 1);
        rh2 = new RoadHole(-100, 2);
        add(player, 0);
        opsCar = new NonPlayableCar();
        add(opsCar, -1);
        add(rh, -1);
        add(rh2, -1);
        for (RoadMark rm : roadMarks) {
            add(rm, -1);    // add to background
        }
        add(roadLabel, -1);

        timer = new Timer(15, this);
        timer.start();
    }
    public Player getPlayer() {
        return player;
    }
    public ArrayList<RoadMark> getRoadMarks() {
        return this.roadMarks;
    }
    @Override   // draw background
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(sideColor);
        g.fillRect(0, 0, sideWidth, height);
        g.fillRect(roadWidth+sideWidth, 0, sideWidth, height);
        moveToBack(this);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if (!GameManager.isGameOver) {
            for (RoadMark rm : roadMarks) {
                rm.addPosY();
            }
            rh.addPosY();
            rh2.addPosY();
            rh.checkCollision(player,fxScreen);
            rh2.checkCollision(player, fxScreen);
            opsCar.addPosY();
            opsCar.checkCollision(player, fxScreen);
            opsCar.detectOtherObstacle(rh);
            opsCar.detectOtherObstacle(rh2);
            // System.out.println("RH\t: (" + rh.getX() + ", " + rh.getY() + ")");
            // System.out.println("RH2\t: (" + rh2.getX() + ", " + rh2.getY() + ")");
            // moveToFront(fxScreen);
        }
    }
}
