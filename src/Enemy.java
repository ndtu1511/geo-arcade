import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;

public class Enemy {
    BufferedImage enemies;
    Vector<BulletEnemy> bulletEnemy;
    int positionEnemyX;
    int positionEnemyY;
    Random random = new Random();
    int vY;
    int count=0;
    boolean isMediumEnemy=false;
    public Enemy(int x,int y,String url){
        this.positionEnemyX=x;
        this.positionEnemyY=y;
        vY = random.nextInt(5)+1;
        try {
            this.enemies = ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        bulletEnemy = new Vector<>();
        if (url.equalsIgnoreCase("resources/square/enemy_square_medium.png")){
            isMediumEnemy=true;
        }
    }
    public void render(Graphics graphics){
        graphics.drawImage(this.enemies,positionEnemyX,positionEnemyY,null);
        for (BulletEnemy bulletEnemy:this.bulletEnemy){
            bulletEnemy.render(graphics);
        }
    }
    public void run(){
        if (!isMediumEnemy){
            this.positionEnemyY+=this.vY;
        }
        else{
            this.positionEnemyY++;
            if (this.count==90) {
                addBullet();
                this.count=0;
            }
            else {
                count++;
            }
        }
    }
    public void addBullet(){
        BulletEnemy bulletEnemy = new BulletEnemy(positionEnemyX+15, positionEnemyY+15, "resources/square/enemy_square_bullet.png", 3);
        this.bulletEnemy.add(bulletEnemy);
    }
    public void runBullet(){
        for (BulletEnemy bulletEnemy : this.bulletEnemy){
            bulletEnemy.shoot();
        }
    }
}
