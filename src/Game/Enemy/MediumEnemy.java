package Game.Enemy;

import Core.GameObject;
import Core.Vector2D;
import Game.Enemy.Bullet.BulletEnemy;
import Physic.BoxCollider;
import utils.Utils;

public class MediumEnemy extends Enemy {
    private EnemyShoot enemyShoot;
    public MediumEnemy() {
        this.velocity = new Vector2D();
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
        boxCollider = new BoxCollider(40,40);
        enemyShoot = new EnemyShoot();
    }

    @Override
    public void run() {
        super.run();
       this.enemyShoot.run(this);
    }
}
