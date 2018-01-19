package Game.Player.Health;

import Core.GameObjectManager;

import java.util.LinkedList;

public class PlayerHealth {
    private int health;
    LinkedList<Heart> linkedList;
    public PlayerHealth(int health) {
        this.health = health;
        linkedList = new LinkedList<>();
        for (int i=0;i<health;i++){
            Heart heart = GameObjectManager.instance.recycle(Heart.class);
            heart.position.set(380.0f-20*i,590.0f);
            linkedList.addFirst(heart);
        }
    }
    public boolean run(){
           linkedList.getFirst().isAlive=false;
           linkedList.removeFirst();
            this.health--;
            if (this.health==0){
                return false;
            }
            return true;
    }
}
