package Core;

import Renderer.Renderer;

import java.awt.*;

public class GameObject {
    public Vector2D position;
    protected Renderer renderer;
    public boolean isAlive;
    public GameObject() {
        this.position = new Vector2D();
        this.isAlive=true;
    }
    public void run(){

    }

    public void render(Graphics graphics){
        if (this.renderer!=null) {
            this.renderer.render(graphics, this.position);
        }
    }
}
