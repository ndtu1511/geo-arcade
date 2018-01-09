import java.awt.*;
import java.util.Random;
public class EnemySqawner extends GameObject {
    private int count =0;
    Random random;
    Enemy enemy;
    public EnemySqawner(){
        this.random = new Random();
    }
    @Override
    public void run(){
        if (this.count >=50){
            int randomEnemy = random.nextInt(4);
            if (randomEnemy==1){
                enemy = new MediumEnemy();
                enemy.velocity.set(0.0f,1.0f);
            }
            else {
                enemy = new Enemy();
                enemy.velocity.set(0.0f,random.nextInt(6)+1);
            }
            enemy.position.set(random.nextInt(400),0.0f);
            GameObject.add(enemy);
            this.count=0;
        }
        else {
            this.count++;
        }
    }
}
