package Game.BackGround;

import Core.GameObject;
import Renderer.ImageRenderer;

public class BackGround extends GameObject {
    public BackGround(){
        this.renderer = new ImageRenderer("resources/background/background.png");
        this.position.set(200,300);
    }
}
