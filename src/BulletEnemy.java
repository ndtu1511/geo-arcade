import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class BulletEnemy extends GameObject {
    Vector2D velocity;
    public BulletEnemy(){
        this.velocity = new Vector2D();
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
    }
}
