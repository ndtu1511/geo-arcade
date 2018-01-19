package Game.Player.Health;

import Core.GameObject;
import Renderer.ImageRenderer;

public class Heart extends GameObject {
    ImageRenderer imageRenderer;
    public Heart() {
        this.renderer = new ImageRenderer("resources/ui/heart.png");
    }
}
