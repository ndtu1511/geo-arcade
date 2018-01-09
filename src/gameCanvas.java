import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

// dùng backbuffer để chuẩn bị trước hình ảnh
public class gameCanvas extends JPanel{
    BufferedImage backGround;
    BufferedImage backBuffered;
    Graphics graphics;
    Player player;
    Random random;
    int count =0;
    public gameCanvas(){
        this.setSize(400,600);
        this.setVisible(true);
        random = new Random();
        this.setupBackBuffer();
        this.setupBackGround();
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupBackGround(){
        try {
            this.backGround = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void setupEnemy(){
        GameObject.add(new EnemySqawner());
    }
    private void setupPlayer(){
        this.player = new Player();
        GameObject.add(player);
    }
    private void setupBackBuffer(){
        this.backBuffered = new BufferedImage(400,600,BufferedImage.TYPE_4BYTE_ABGR);
        this.graphics = this.backBuffered.getGraphics();
    }
    @Override
    protected void paintComponent(Graphics g) {
        g.drawImage(this.backBuffered,0,0,null);
    }
    public void renderAll(){
        this.graphics.drawImage(this.backGround,0,0,null);
        GameObject.renderAll(graphics);
        this.repaint();
    }
    public void runAll(){
        GameObject.runAll();
    }
}
