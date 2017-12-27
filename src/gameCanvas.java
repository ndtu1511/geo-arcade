import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// dùng backbuffer để chuẩn bị trước hình ảnh
public class gameCanvas extends JPanel{
    BufferedImage backGround,player,enemySmall;
    BufferedImage backBuffered;
    Graphics graphics;
    public int positionPlayerX = 200;
    public int positionPlayerY = 300;
//    public int xEnemy = 100;
//    public int yEnemy = 0;
    public gameCanvas(){
        this.setSize(400,600);
        this.setVisible(true);
        this.setupBackBuffer();
        this.setupBackGround();
        this.setupPlayer();
    }

    private void setupBackGround(){
        try {
            this.backGround = ImageIO.read(new File("resources/background/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    private void setupPlayer(){
        try {
            this.player = ImageIO.read(new File("resources/player/straight.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
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
        this.graphics.drawImage(this.player,positionPlayerX-20,positionPlayerY-30,null);
        this.repaint();
    }
}
