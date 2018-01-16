package Game.BackGround;

import Core.GameObject;
import utils.Utils;

import java.awt.*;

public class BackGround extends GameObject {
    public BackGround(){
        this.image = Utils.loadImage("resources/background/background.png");
    }

    @Override
    public void render(Graphics graphics) {
        if (this.image!=null){
            graphics.drawImage(this.image,(int)this.position.x,(int)this.position.y,null);
        }
    }
}
