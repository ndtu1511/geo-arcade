package Game.Player.Bullet;

import Core.GameObjectManager;
import Game.Enemy.Bullet.BulletEnemy;

public class HitBulletEnemy {
    public void run(BulletPlayer bulletPlayer){
        BulletEnemy bulletEnemy = GameObjectManager.instance.checkCollider(bulletPlayer.boxCollider,BulletEnemy.class);
        if (bulletEnemy!=null){
            bulletPlayer.getHit();
            bulletEnemy.getHit();
        }
    }
}
