package Game.Player.Bullet;

import Core.GameObjectManager;
import Game.Enemy.Enemy;

public class HitEnemy {
    public void run(BulletPlayer bulletPlayer){
        Enemy enemy = GameObjectManager.instance.checkCollider(bulletPlayer.boxCollider,Enemy.class);
        if (enemy!=null){
            bulletPlayer.getHit();
            enemy.getHit();
        }
    }
}
