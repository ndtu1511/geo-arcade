import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class enemy {
    BufferedImage enemies;
    int positionEnemyX;
    int positionEnemyY;
    int x=-2;
    int y=4;
    public enemy(int x,int y){
        this.positionEnemyX=x;
        this.positionEnemyY=y;
        this.setupEnemies();

    }
    private void setupEnemies(){
        try {
            this.enemies = ImageIO.read(new File("resources/square/enemy_square_small.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void btap1(){
        positionEnemyY+=5;
        if (positionEnemyY>=600){
            positionEnemyY=0;
        }
    }
    public void btap2(){
        positionEnemyX+=x;
        positionEnemyY+=y;
        if (positionEnemyX<=0 || positionEnemyX>=382){
            x=-x;
        }
        if (positionEnemyY<=0 || positionEnemyY>=582){
            y=-y;
        }
    }
}
