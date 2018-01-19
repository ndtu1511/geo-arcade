package Game.Enemy;

import Core.Vector2D;
import Physic.BoxCollider;
import Renderer.ImageRenderer;

public class MediumEnemy extends Enemy {
    private EnemyShoot enemyShoot;
    public MediumEnemy() {
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/square/enemy_square_medium.png");
        boxCollider = new BoxCollider(40,40);
        enemyShoot = new EnemyShoot();
    }

    @Override
    public void run() {
        super.run();
       this.enemyShoot.run(this);
    }
}
