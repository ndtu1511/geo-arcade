import Core.GameObject;
import Game.BackGround.BackGround;
import Game.Enemy.CircleEnemy;
import Game.Enemy.EnemyShoot;
import Game.Enemy.EnemySqawner;
import Game.Enemy.MatrixEnemy;
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
    public Player player;
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

    private void setupBackGround(){
        GameObject.add(new BackGround());
    }
    private void setupEnemy(){
        GameObject.add(new EnemySqawner());
        GameObject.add(new CircleEnemy());
        GameObject.add(new MatrixEnemy());
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
