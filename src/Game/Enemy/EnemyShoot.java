package Game.Enemy;

import Core.FrameCounter;
import Core.GameObject;
import Core.Vector2D;
import Game.Enemy.Bullet.BulletEnemy;
import Game.Enemy.Bullet.BulletFollow;
import Game.Player.Player;

public class EnemyShoot {
    private FrameCounter frameCounter = new FrameCounter(40);

    public void run(Enemy enemy){
        if (this.frameCounter.run()){
//            BulletEnemy bulletEnemy = new BulletEnemy();
            BulletEnemy bulletEnemy = new BulletFollow();
            bulletEnemy.position.set(enemy.position);
            bulletEnemy.velocity.set(0.0f,3.0f);
            GameObject.add(bulletEnemy);
            this.frameCounter.reset();
        }
    }
}
