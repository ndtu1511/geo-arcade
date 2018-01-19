package Game.Player.Bullet;

import Core.GameObject;
import Core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class BulletPlayer extends GameObject implements PhysicBody {
    public Vector2D velocity;
    public BoxCollider boxCollider;
    HitEnemy hitEnemy;
    HitBulletEnemy hitBulletEnemy;
    public BulletPlayer(){
        this.renderer = new ImageRenderer("resources/player/player_bullet.png");
        this.velocity = new Vector2D();
        this.boxCollider = new BoxCollider(13,10);
        this.hitEnemy = new HitEnemy();
        this.hitBulletEnemy = new HitBulletEnemy();
    }
    @Override
    public void run(){
        super.run();
        this.position.subtractBy(this.velocity);
        this.boxCollider.position.set(this.position);
        this.hitEnemy.run(this);
        this.hitBulletEnemy.run(this);
        if (this.position.y<=0){
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
