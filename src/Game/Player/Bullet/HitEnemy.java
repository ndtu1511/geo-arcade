package Game.Player.Bullet;

import Core.GameObject;
import Game.Enemy.Enemy;

public class HitEnemy {
    public void run(BulletPlayer bulletPlayer){
        Enemy enemy = GameObject.checkCollider(bulletPlayer.boxCollider,Enemy.class);
        if (enemy!=null){
            bulletPlayer.getHit();
            enemy.getHit();
        }
    }
}
