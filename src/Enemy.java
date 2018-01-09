import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Enemy extends GameObject {
    Vector2D velocity;
    public Enemy(){
        velocity = new Vector2D();
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
    }
}
