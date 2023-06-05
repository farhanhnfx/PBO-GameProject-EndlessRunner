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
    public RoadHole rh;
    public RoadHole rh2;
    private Player player;
    private CollisionEffect fxScreen;
    public NonPlayableCar npCar;
    private PowerUp healObj;
    // private Board board;

    public Environment() {
        roadImg = new ImageIcon("src/assets/Road.png");
        roadLabel = new JLabel(roadImg);
        roadLabel.setBounds(80, 0, 352, 640);
        setLayout(null);
        

        player = GameManager.player;

        //Object Declaration
        fxScreen = new CollisionEffect();
        npCar = new NonPlayableCar();
        roadMarks = new ArrayList<>();
        rh = new RoadHole(-100, 1);
        rh2 = new RoadHole(-700, 2);
        healObj = new PowerUp(-5000);


        roadMarks.add(new RoadMark(0));
        roadMarks.add(new RoadMark(roadMarks.get(0).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(1).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(2).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(3).getPosY() + markGap));
        roadMarks.add(new RoadMark(roadMarks.get(4).getPosY() + markGap));

        //Adding object to the panel
        add(GameManager.board);
        add(player, 0);
        add(fxScreen);
        add(npCar, -1);
        add(rh, -1);
        add(rh2, -1);
        add(healObj, -1);

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

    //Automation Handling
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!GameManager.isGameOver) {
            for (RoadMark rm : roadMarks) {
                rm.addPosY();
            }

            rh.addPosY();
            rh2.addPosY();
            npCar.addPosY();
            healObj.addPosY();

            rh.checkCollision(player,fxScreen);
            rh2.checkCollision(player, fxScreen);
            npCar.checkCollision(player, fxScreen);
            healObj.checkCollision(player, fxScreen);

            npCar.detectOtherObstacle(rh);
            npCar.detectOtherObstacle(rh2);
        }
    }
}
