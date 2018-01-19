package Game.Enemy.Bullet;

import Core.GameObjectManager;
import Core.Vector2D;
import Game.Player.Player;

public class BulletFollow extends BulletEnemy {
    Vector2D v;
    Player player;
    public BulletFollow(){
        v = new Vector2D();
        this.player = GameObjectManager.instance.isPlayer();
    }

    @Override
    public void run() {
        super.run();
        v = this.player.position.subtract(this.position);
        this.velocity.set(v.normalize().x*5,v.normalize().y*5);
    }
}
