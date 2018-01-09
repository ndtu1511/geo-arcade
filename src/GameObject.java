import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

public class GameObject {
    public Vector2D position;
    protected BufferedImage image;

    static private Vector<GameObject> vector = new Vector<>();
    static private Vector<GameObject> newVector = new Vector<>();

    public static void add(GameObject gameObject){
        newVector.add(gameObject);
    }

    public static void runAll(){
        for (GameObject gameObject:vector){
            gameObject.run();
        }
        vector.addAll(newVector);
        newVector.clear();
    }

    public static void renderAll(Graphics graphics){
        for (GameObject gameObject: vector){
            gameObject.render(graphics);
        }
    }
    public GameObject() {
        this.position = new Vector2D();
    }

    public void run(){

    }
    public void render(Graphics graphics){
        if (this.image!=null){
            graphics.drawImage(this.image,(int)this.position.x-this.image.getWidth()/2,(int)this.position.y-this.image.getHeight()/2,null);
        }
    }
}
