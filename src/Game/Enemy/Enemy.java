package Game.Enemy;

import Core.GameObject;
import Core.Vector2D;
import Game.Enemy.Bullet.HitPlayer;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.ImageRenderer;

public class Enemy extends GameObject implements PhysicBody {
    Vector2D velocity;
    public BoxCollider boxCollider;
    HitPlayer hitPlayer;
    public Enemy(){
        velocity = new Vector2D();
        hitPlayer = new HitPlayer();
        this.renderer = new ImageRenderer("resources/square/enemy_square_small.png");
        boxCollider = new BoxCollider(20,20);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position);
        this.hitPlayer.run(this);
        if (this.position.y>620){
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
