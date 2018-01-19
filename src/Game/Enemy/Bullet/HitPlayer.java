package Game.Enemy.Bullet;

import Core.GameObjectManager;
import Game.Enemy.Enemy;
import Game.Player.Player;

public class HitPlayer {
    public void run (Enemy enemy){
        Player player = GameObjectManager.instance.checkCollider(enemy.boxCollider,Player.class);
        if (player!=null){
            player.getHit();
            enemy.getHit();
        }
    }
}
