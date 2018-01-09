import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletPlayer extends GameObject {
    public Vector2D velocity;
    public BulletPlayer(){
        this.image = Utils.loadImage("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
    }
    @Override
    public void run(){
        super.run();
        this.position.subtractBy(this.velocity);
    }
    @Override
    public void render(Graphics graphics){
        graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
    }
}
