import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletPlayer {
    public int x;
    public int y;
    public BufferedImage image;
    public int speed;
    public BulletPlayer(int x, int y, String url, int speed){
        this.x = x;
        this.y = y;
        this.speed = speed;
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void shoot(){
        this.y-=this.speed;
    }
    public void shoot(String s){
        if (s.equalsIgnoreCase("left")){
            this.y -=this.speed;
            this.x -= this.speed;
        }
        if (s.equalsIgnoreCase("right")){
            this.y -= this.speed;
            this.x += this.speed;
        }
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.image,this.x,this.y,null);
    }
}
