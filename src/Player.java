import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

public class Player {
    int x;
    int y;
    int count=0;
    BufferedImage image;
    Vector<BulletPlayer> vectorBullet;
    public Player(String url){
        try {
            this.image = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.vectorBullet = new Vector<>();
    }
    public void render(Graphics graphics){
        graphics.drawImage(image,this.x-20,this.y-30,null);
        for (BulletPlayer bulletPlayer:this.vectorBullet) {
            bulletPlayer.render(graphics);
        }
    }
    public void addBullet(){
        if (this.count==50) {
            BulletPlayer bulletPlayer = new BulletPlayer(x, y, "resources/player/player_bullet.png", 3,0);
            BulletPlayer bulletPlayerLeft = new BulletPlayer(x, y, "resources/player/player_bullet.png", 3,3);
            BulletPlayer bulletPlayerRight = new BulletPlayer(x, y, "resources/player/player_bullet.png", 3,-3);
            this.vectorBullet.add(bulletPlayer);
            this.vectorBullet.add(bulletPlayerLeft);
            this.vectorBullet.add(bulletPlayerRight);
            this.count = 0;
        }
        else{
            count++;
        }
    }
    public void moveBullet(){
        for (BulletPlayer bulletPlayer : this.vectorBullet) {
            bulletPlayer.shoot();
        }
    }
}
