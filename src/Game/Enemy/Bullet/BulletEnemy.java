package Game.Enemy.Bullet;

import Core.GameObject;
import Core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class BulletEnemy extends GameObject implements PhysicBody {
    public Vector2D velocity;
    BoxCollider boxCollider;
    public BulletEnemy(){
        this.velocity = new Vector2D();
        this.renderer = new ImageRenderer("resources/square/enemy_square_bullet.png");
        this.boxCollider = new BoxCollider(10,10);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(this.velocity);
        this.boxCollider.position.set(this.position);
        if (this.position.y>610){
            this.isAlive=false;
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
    public void getHit(){
        this.isAlive=false;
    }
}
