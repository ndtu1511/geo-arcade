import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Player {
    int x;
    int y;
    BufferedImage image;
    public Player(String url){
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void render(Graphics graphics){
        graphics.drawImage(image,this.x-20,this.y-30,null);
    }
}
