package Game.Enemy;

import Core.FrameCounter;
import Core.GameObject;
import Core.GameObjectManager;

import java.util.Random;
public class EnemySqawner extends GameObject {
    private int count =0;
    Random random;
//    Enemy enemy;
    FrameCounter frameCounter;
    public EnemySqawner(){
        this.random = new Random();
        this.frameCounter = new FrameCounter(50);
    }
    @Override
    public void run(){
        if (frameCounter.run()){
            int randomEnemy = random.nextInt(4);
            if (randomEnemy==1){
                Enemy enemy = GameObjectManager.instance.recycle(MediumEnemy.class);
                enemy.position.set(random.nextInt(400),0.0f);
                enemy.velocity.set(0.0f,1.0f);
            }
            else {
                Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                enemy.position.set(random.nextInt(400),0.0f);
                enemy.velocity.set(0.0f,random.nextInt(6)+1);
            }
//            GameObjectManager.instance.add(enemy);
            this.frameCounter.reset();
        }
    }
}
