package Game.Player;

import Core.FrameCounter;
import Core.GameObject;
import Game.Player.Health.PlayerHealth;
import Input.MouseMotionInput;
import Physic.BoxCollider;
import Physic.PhysicBody;
import Renderer.AnimationRenderer;
import Renderer.ImageRenderer;

public class Player extends GameObject implements PhysicBody {
    private PlayerShoot playerShoot;
    private PlayerHealth playerHealth;
    FrameCounter frameCounter;
    BoxCollider boxCollider;
    private ImageRenderer imageRenderer;
    private AnimationRenderer animationRenderer;
    public Player(){
        frameCounter = new FrameCounter(5);
        this.imageRenderer = new ImageRenderer("resources/player/straight.png");
        this.animationRenderer=new AnimationRenderer(false,
                "resources/player/straight.png",
                "resources/player/straight_white.png",
                "resources/player/straight.png",
                "resources/player/straight_white.png"
                );
        this.renderer =this.imageRenderer;
        this.playerHealth = new PlayerHealth(5);
        this.boxCollider = new BoxCollider(30,30);
        playerShoot = new PlayerShoot();
    }
    @Override
    public void run() {
        super.run();
        this.position.set(MouseMotionInput.instance.position);
        this.playerShoot.run(this);
        this.boxCollider.position.set(this.position);
        if (this.animationRenderer.isDone()){
            this.renderer = this.imageRenderer;
            this.animationRenderer.setDone(false);
        }
    }

    @Override
    public BoxCollider getBoxCollider() {
        return this.boxCollider;
    }
    public void getHit(){
        this.isAlive=this.playerHealth.run();
        if (this.isAlive){
            this.renderer = this.animationRenderer;
        }
    }
}
