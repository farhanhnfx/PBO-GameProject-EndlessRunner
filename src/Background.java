import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Background extends JLayeredPane implements ActionListener {
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
    private Player player;
    private CollisionEffect fxScreen;

    public Background() {
        roadImg = new ImageIcon("src/assets/Road.png");
        roadLabel = new JLabel(roadImg);
        roadLabel.setBounds(80, 0, 352, 640);
        setLayout(null);

        player = new Player();
        fxScreen = new CollisionEffect();
        add(fxScreen);


        roadMarks = new ArrayList<>();
        roadMarks.add(new RoadMark(0));
        roadMarks.add(new RoadMark(roadMarks.get(0).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(1).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(2).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(3).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(4).getPosY() + markGap));
        for (RoadMark rm : roadMarks) {
            add(rm, 0);    // add to background
        }
        rh = new RoadHole(30, 1);
        add(player, 2);
        add(rh, 1);
        add(roadLabel, -1);

        timer = new Timer(15, this);
        timer.start();
        moveToFront(player);
    }
    public RoadHole getRh() {
        return rh;
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
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        for (RoadMark rm : roadMarks) {
            rm.addPosY();
        }
        rh.addPosY();
        rh.checkCollision(player,fxScreen);
        moveToFront(fxScreen);
        player.score++;
        if (player.score%50 == 0) {
            System.out.println("SCORE: " + player.score);
        }
    }
}
