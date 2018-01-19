import Core.GameObjectManager;
import Game.BackGround.BackGround;
import Game.Enemy.EnemySqawner;
import Game.Player.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

// dùng backbuffer để chuẩn bị trước hình ảnh
public class GameCanvas extends JPanel{
    BufferedImage backGround;
    BufferedImage backBuffered;
    Graphics graphics;
    Random random;
    int count =0;
    public GameCanvas(){
        this.setSize(40,40);
        this.setVisible(true);
        random = new Random();
        this.setupBackBuffer();
        this.setupBackGround();
        this.setupPlayer();
        this.setupEnemy();
    }

    private void setupBackGround() {
        GameObjectManager.instance.recycle(BackGround.class);
    }
    private void setupEnemy(){
        GameObjectManager.instance.recycle(EnemySqawner.class);
//        GameObjectManager.instance.recycle(CircleEnemy.class);
//        GameObjectManager.instance.recycle(MatrixEnemy.class);
    }
    private void setupPlayer(){
        GameObjectManager.instance.recycle(Player.class);
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
        GameObjectManager.instance.renderAll(graphics);
        this.repaint();
    }
    public void runAll(){
        GameObjectManager.instance.runAll();
    }
}
