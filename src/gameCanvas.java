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
    Vector<BulletPlayer> vectorBullet;
    Vector<BulletPlayer> vectorBulletLeft;
    Vector<BulletPlayer> vectorBulletRight;
    Vector<Enemy> vectorEnemy;
    Vector<Enemy> enemyMedium;
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
        vectorEnemy = new Vector<>();
        enemyMedium = new Vector<>();
    }
    private void setupPlayer(){
        this.player = new Player("resources/player/straight.png");
        this.vectorBullet = new Vector<>();
        this.vectorBulletLeft = new Vector<>();
        this.vectorBulletRight = new Vector<>();
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
        player.render(this.graphics);
        for (BulletPlayer bulletPlayer:this.vectorBullet) {
            bulletPlayer.render(this.graphics);
        }
        for (BulletPlayer bulletPlayer:this.vectorBulletLeft){
            bulletPlayer.render(this.graphics);
        }
        for (BulletPlayer bulletPlayer:this.vectorBulletRight){
            bulletPlayer.render(this.graphics);
        }
        for (Enemy enemies:this.vectorEnemy){
            enemies.render(this.graphics);
        }
        for (Enemy enemy:this.enemyMedium){
            enemy.render(this.graphics);
        }
        this.repaint();
    }
    public void runAll(){
        if (this.count==30){
            int randomPositionEnemies = random.nextInt(400);
            int randomMediumEnemies = random.nextInt(4);
            BulletPlayer bulletPlayer = new BulletPlayer(player.x, player.y,"resources/player/player_bullet.png",3);
            BulletPlayer bulletPlayerLeft = new BulletPlayer(player.x, player.y,"resources/player/player_bullet.png",3);
            BulletPlayer bulletPlayerRight = new BulletPlayer(player.x, player.y,"resources/player/player_bullet.png",3);
            if (randomMediumEnemies==1){
                Enemy enemy = new Enemy(randomPositionEnemies,0,"resources/square/enemy_square_medium.png");
                this.enemyMedium.add(enemy);
            }
            else {
                Enemy enemy = new Enemy(randomPositionEnemies, 0, "resources/square/enemy_square_small.png");
                this.vectorEnemy.add(enemy);
            }
            this.vectorBullet.add(bulletPlayer);
            this.vectorBulletLeft.add(bulletPlayerLeft);
            this.vectorBulletRight.add(bulletPlayerRight);
            this.count=0;
        }
        else {
            this.count++;
        }
        for (BulletPlayer bulletPlayer:this.vectorBullet){
            bulletPlayer.shoot();
        }
        for (BulletPlayer bulletPlayer:this.vectorBulletLeft){
            bulletPlayer.shoot("left");
        }
        for (BulletPlayer bulletPlayer:this.vectorBulletRight){
            bulletPlayer.shoot("right");
        }
        for (Enemy enemies : this.vectorEnemy){
            enemies.run();
        }
        for (Enemy enemy : this.enemyMedium) {
            enemy.run();
            enemy.runBullet();
        }
    }
}
