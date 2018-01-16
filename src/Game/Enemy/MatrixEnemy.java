package Game.Enemy;

import Core.FrameCounter;
import Core.GameObject;
import Core.Vector2D;

import java.util.Vector;

public class MatrixEnemy extends GameObject {
    Vector2D velocity;
    Vector<Enemy> enemies;
    String[][] s = {
            {"*","*","*",},
            {" ","*"," ",},
            {" ","*"," ",},
            {" ","*"," ",},
            {" ","*"," ",},
    };
    FrameCounter frameCounter;
    int width = s[0].length;
    int height = s.length;
    float vX=2.0f;
    float y=0;
    boolean goDown;
    public MatrixEnemy(){
        enemies = new Vector<>();
        this.velocity = new Vector2D(vX,0.0f);
        frameCounter = new FrameCounter(10);
        for (int i=0;i<this.height;i++){
            for (int j=0;j<this.width;j++){
                if (s[i][j].equalsIgnoreCase("*")){
                    Enemy enemy = new Enemy();
                    enemy.position.set(j*20+10,i*20+10.0f);
                    enemies.add(enemy);
                    GameObject.add(enemy);
                }
            }
        }
        this.goDown=false;
    }

    @Override
    public void run() {
        super.run();
        for (Enemy enemy:enemies) {
            if (enemy.position.x <= 0 || enemy.position.x >= 400) {
                if (!goDown) {
                    y = enemy.position.y;
                    goDown=true;
                }
                this.velocity.set(0.0f,1.0f);
                if (enemy.position.y==y+15.0f) {
                    this.vX = -this.vX;
                    this.velocity.set(vX,0.0f);
                    goDown=false;
                }
                break;
            }
        }
        for (Enemy enemy:enemies){
            enemy.velocity.set(this.velocity);
        }
    }
}
