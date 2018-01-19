package Core;

import Game.Player.Player;
import Physic.BoxCollider;
import Physic.PhysicBody;

import java.awt.*;
import java.util.Vector;

public class GameObjectManager {
    public static GameObjectManager instance = new GameObjectManager();
    private Vector<GameObject> vector;
    private Vector<GameObject> newVector;
    private GameObjectManager() {
        this.vector = new Vector<>();
        this.newVector = new Vector<>();
    }

    public void add(GameObject gameObject){
        newVector.add(gameObject);
    }

    public void runAll(){
        for (GameObject gameObject:vector){
            if (gameObject.isAlive) {
                gameObject.run();
            }
        }
        vector.addAll(newVector);
        newVector.clear();
    }

    public void renderAll(Graphics graphics){
        for (GameObject gameObject: vector){
            if (gameObject.isAlive) {
                gameObject.render(graphics);
            }
        }
    }
    public <T extends GameObject> T checkCollider(BoxCollider boxCollider, Class<T> cls){
        for (GameObject gameObject:vector){
            if (!gameObject.isAlive) continue;
            if (!cls.isInstance(gameObject)) continue;
            if (!(gameObject instanceof PhysicBody)) continue;
            BoxCollider other = ((PhysicBody) gameObject).getBoxCollider();
            if (boxCollider.checkCollider(other)){
                return (T) gameObject;
            }
        }
        return null;
    }
    public <T extends  GameObject> T recycle(Class<T> cls){
        for (GameObject gameObject : vector){
            if (gameObject.isAlive) continue;
            if (!cls.isInstance(gameObject)) continue;
            gameObject.isAlive=true;
            return (T) gameObject;
        }
        try {
            T instance = cls.newInstance();
            this.add(instance);
            return instance;
        } catch (InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }

    }
    public Player isPlayer(){
        for (GameObject gameObject:vector){
            if (gameObject instanceof Player){
                return (Player) gameObject;
            }
        }
        return null;
    }
}
