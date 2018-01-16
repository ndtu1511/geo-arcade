package Game.Enemy.Bullet;

import Core.GameObject;
import Core.Vector2D;
import Game.Player.Player;

public class BulletFollow extends BulletEnemy {
    Vector2D v;
    Player player;
    public BulletFollow(){
        v = new Vector2D();
        this.player = GameObject.isPlayer();
    }

    @Override
    public void run() {
        super.run();
        v = this.player.position.subtract(this.position);
        this.velocity.set(v.normalize().x*2,v.normalize().y*2);
    }
}
