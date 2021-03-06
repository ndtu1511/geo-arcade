package Game.Enemy;

import Core.GameObject;
import Core.GameObjectManager;
import Core.Vector2D;

import java.util.Vector;

public class CircleEnemy extends GameObject {
    Vector2D veclocity;
    Vector<Enemy> enemies;
    public CircleEnemy(){
            this.veclocity = new Vector2D(2.0f,3.0f);
            enemies = new Vector<>();
            for (double angle =0.0;angle<=360.0;angle+=360.0/15){
                Enemy enemy = GameObjectManager.instance.recycle(Enemy.class);
                enemy.position.set(new Vector2D(50.0f,10.0f).rotate(angle,new Vector2D(60.0f,60.0f)));
                enemy.velocity.set(this.veclocity);
                enemies.add(enemy);
            }
    }

    @Override
    public void run() {
        super.run();
        for (Enemy enemy:enemies){
            if (!enemy.isAlive){
                this.enemies.remove(enemy);
                break;
            }
        }
        for (Enemy enemy:this.enemies){
            if (enemy.position.x<=0.0f||enemy.position.x>=390){
                this.veclocity.x=-this.veclocity.x;
                break;
            }
            if (enemy.position.y<=0.0f||enemy.position.y>=590){
                this.veclocity.y=-this.veclocity.y;
                break;
            }
        }
        for (Enemy enemy:enemies) {
            enemy.velocity.set(this.veclocity);
        }
    }
}
