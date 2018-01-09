import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Player extends GameObject {
    int count=0;
    public Player(){
        this.image = Utils.loadImage("resources/player/straight.png");
    }
    @Override
    public void run() {
        super.run();
        if (this.count==50){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(this.position);
            bulletPlayer.velocity.set(0.0f,3.0f);
            GameObject.add(bulletPlayer);
            this.count=0;
        }
        else {
            count++;
        }
    }
}
