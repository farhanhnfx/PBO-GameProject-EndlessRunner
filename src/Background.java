import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Background extends JPanel {
    private final int roadWidth = 320;
    private final int sideWidth = 96;
    private final int height = GamePanel.height;
    private final Color roadColor = new Color(71, 71, 71);
    private final Color sideColor = new Color(166, 177, 98);
    private final int markGap = 224;        // road mark vertical gap
    private ArrayList<RoadMark> roadMarks;  // list of road marks

    public Background() {
        roadMarks = new ArrayList<>();
        roadMarks.add(new RoadMark(0));
        roadMarks.add(new RoadMark(roadMarks.get(0).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(1).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(2).getPosY() + markGap));
        for (RoadMark rm : roadMarks) {
            add(rm);    // add to background
        }
    }
    public ArrayList<RoadMark> getRoadMarks() {
        return this.roadMarks;
    }
    @Override   // draw background
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(sideColor);
        g.fillRect(0, 0, sideWidth, height);

        g.setColor(roadColor);
        g.fillRect(sideWidth, 0, roadWidth, height);

        g.setColor(sideColor);
        g.fillRect(roadWidth+sideWidth, 0, sideWidth, height);
    }
}
