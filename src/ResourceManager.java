import java.awt.Font;
import java.awt.FontFormatException;
import java.awt.GraphicsEnvironment;
import java.io.IOException;
import java.io.InputStream;

public class ResourceManager {
    public static final Font POPPINS_LIGHT;
    public static final Font POPPINS_BOLD;

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
    }

    private ResourceManager() {}
}
