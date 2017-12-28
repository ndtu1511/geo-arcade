import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

// dùng backbuffer để chuẩn bị trước hình ảnh
public class gameCanvas extends JPanel{
    BufferedImage backGround,player;
    BufferedImage backBuffered;
    Graphics graphics;
    enemy enemy1;
    enemy enemy2;
    enemy[] enemy3;
    public int positionPlayerX = 200;
    public int positionPlayerY = 300;
    int sizeBT3=10;
    public gameCanvas(){
        this.setSize(400,600);
        this.setVisible(true);
        this.enemy1 = new enemy(100,0);
        this.enemy2 = new enemy(250,0);
        this.enemy3 = new enemy[sizeBT3];
        for (int i=0;i<sizeBT3;i++){
            this.enemy3[i] = new enemy(i*40,0);
        }
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
        this.graphics.drawImage(enemy1.enemies, enemy1.positionEnemyX, enemy1.positionEnemyY,null);
        this.graphics.drawImage(enemy2.enemies, enemy2.positionEnemyX, enemy2.positionEnemyY,null);
        for (int i=0;i<sizeBT3;i++){
            this.graphics.drawImage(enemy3[i].enemies,enemy3[i].positionEnemyX,enemy3[i].positionEnemyY,null);
        }
        this.repaint();
    }
}
