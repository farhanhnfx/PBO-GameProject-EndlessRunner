import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Background extends JPanel {
    private final int roadWidth = 352;
    private final int sideWidth = 80;
    private final int height = GamePanel.height;
    // private final Color roadColor = new Color(71, 71, 71);
    private final Color sideColor = new Color(166, 177, 98);
    private final int markGap = 224;        // road mark vertical gap
    private ArrayList<RoadMark> roadMarks;  // list of road marks
    private ImageIcon roadImg;
    private JLabel roadLabel;

    public Background() {
        roadImg = new ImageIcon("src/assets/Road.png");
        roadLabel = new JLabel(roadImg);
        roadLabel.setBounds(80, 0, 352, 640);
        // add(roadLabel);
        setLayout(null);

        Player player = new Player();

        roadMarks = new ArrayList<>();
        roadMarks.add(new RoadMark(0));
        roadMarks.add(new RoadMark(roadMarks.get(0).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(1).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(2).getPosY() + markGap));
        // player.addKeyListener(player);
        // player.setFocusable(true);
        add(player.getCarLabel());
        // add(player);
        for (RoadMark rm : roadMarks) {
            // rm.setBounds(RoadMark.posX, rm.getPosY(), RoadMark.width, RoadMark.height);
            add(rm);    // add to background
        }
        add(roadLabel);
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
}
