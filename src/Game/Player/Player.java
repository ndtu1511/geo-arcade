package Game.Player;

import Core.GameObject;
import Physic.BoxCollider;
import Physic.PhysicBody;
import utils.Utils;

public class Player extends GameObject implements PhysicBody {
    private PlayerShoot playerShoot;
    BoxCollider boxCollider;
    public Player(){
        this.image = Utils.loadImage("resources/player/straight.png");
        this.boxCollider = new BoxCollider(30,30);
        playerShoot = new PlayerShoot();
    }
    @Override
    public void run() {
        super.run();
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
}
