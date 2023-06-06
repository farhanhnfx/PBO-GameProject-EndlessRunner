import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

import javax.swing.ImageIcon;

public class ResourceManager {
    public static final Font POPPINS_LIGHT;
    public static final Font POPPINS_BOLD;
    public static final ImageIcon[] NPC_CARS;
    public static final ImageIcon PLAYER_CAR;
    public static final ImageIcon GAME_TITLE_IMG;
    public static final ImageIcon START_BG;
    public static final ImageIcon BOARD_BG;
    public static final ImageIcon ENGINE_IMG;
    public static final ImageIcon POWERUP_IMG;
    public static final ImageIcon[] ROADHOLE_IMGS;

    static {
        Font poppinsLight = null;
        Font poppinsBold = null;

        try {
            InputStream poppinsLightStream = ResourceManager.class.getResourceAsStream("/assets/Poppins-Light.ttf");
            InputStream poppinsBoldStream = ResourceManager.class.getResourceAsStream("/assets/Poppins-Bold.ttf");

            poppinsLight = Font.createFont(Font.TRUETYPE_FONT, poppinsLightStream);
            poppinsBold = Font.createFont(Font.TRUETYPE_FONT, poppinsBoldStream);

            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(poppinsLight);
            ge.registerFont(poppinsBold);

            poppinsLightStream.close();
            poppinsBoldStream.close();
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        POPPINS_LIGHT = poppinsLight;
        POPPINS_BOLD = poppinsBold;

        NPC_CARS = new ImageIcon[3];
        NPC_CARS[0] = new ImageIcon("src/assets/Car_Red.png");
        NPC_CARS[1] = new ImageIcon("src/assets/Car_Blue.png");
        NPC_CARS[2] = new ImageIcon("src/assets/Car_Yellow.png");
        PLAYER_CAR = new ImageIcon("src/assets/Car.png");
        GAME_TITLE_IMG = new ImageIcon("src/assets/title2.png");
        START_BG = new ImageIcon("src/assets/background.jpg");
        BOARD_BG = new ImageIcon("src/assets/BgBoard.png");
        ENGINE_IMG = new  ImageIcon("src/assets/engine.png");
        POWERUP_IMG = new ImageIcon("src/assets/PowerUp.png");
        ROADHOLE_IMGS = new ImageIcon[2];
        ROADHOLE_IMGS[0] = new ImageIcon("src/assets/Obstacle1.png");
        ROADHOLE_IMGS[1] = new ImageIcon("src/assets/Obstacle2_Small.png");
    }

    private ResourceManager() {}
}
