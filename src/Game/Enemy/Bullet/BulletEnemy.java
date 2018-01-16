package Game.Enemy.Bullet;

import Core.GameObject;
import Core.Vector2D;
import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;
import utils.Utils;

public class BulletEnemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    BoxCollider boxCollider;
    public BulletEnemy(){
        this.velocity = new Vector2D();
        this.image = Utils.loadImage("resources/square/enemy_square_bullet.png");
        this.boxCollider = new BoxCollider(10,10);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
    public void getHit(){
        this.isAlive=false;
        System.out.println("Bullet get hit");
    }
}
