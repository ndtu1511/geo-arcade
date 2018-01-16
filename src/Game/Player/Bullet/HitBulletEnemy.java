package Game.Player.Bullet;

import Core.GameObject;
import Game.Enemy.Bullet.BulletEnemy;

public class HitBulletEnemy {
    public void run(BulletPlayer bulletPlayer){
        BulletEnemy bulletEnemy = GameObject.checkCollider(bulletPlayer.boxCollider,BulletEnemy.class);
        if (bulletEnemy!=null){
            bulletPlayer.getHit();
            bulletEnemy.getHit();
        }
    }
}
