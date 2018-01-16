package Game.Enemy;

import Core.GameObject;
import Core.Vector2D;
import Physic.BoxCollider;
import Physic.PhysicBody;
import utils.Utils;

public class Enemy extends GameObject implements PhysicBody {
    Vector2D velocity;
    public BoxCollider boxCollider;
    public Enemy(){
        velocity = new Vector2D();
        this.image = Utils.loadImage("resources/square/enemy_square_small.png");
        boxCollider = new BoxCollider(20,20);
    }
    @Override
    public void run() {
        super.run();
        this.position.addUp(velocity);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
    public void getHit(){
        this.isAlive=false;
        System.out.println("Enemy get Hit");
    }
}
