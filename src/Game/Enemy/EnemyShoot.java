package Game.Enemy;

import Core.FrameCounter;
import Core.GameObjectManager;
import Game.Enemy.Bullet.BulletEnemy;

public class EnemyShoot {
    private FrameCounter frameCounter = new FrameCounter(40);

    public void run(Enemy enemy){
        if (this.frameCounter.run()){
            BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletEnemy.class);
//            BulletEnemy bulletEnemy = GameObjectManager.instance.recycle(BulletFollow.class);
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(0.0f,3.0f);
//            GameObjectManager.instance.add(bulletEnemy);
            this.frameCounter.reset();
        }
    }
}
