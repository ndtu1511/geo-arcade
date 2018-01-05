import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletPlayer {
    public int x;
    public int y;
    public BufferedImage image;
    public int speedY;
    public int speedX;
    public BulletPlayer(int x, int y, String url, int speedY, int speedX){
        this.x = x;
        this.y = y;
        this.speedY = speedY;
        this.speedX = speedX;
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void shoot(){
        this.y-=this.speedY;
        this.x -=this.speedX;
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,null);
    }
}
