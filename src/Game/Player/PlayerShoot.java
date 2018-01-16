package Game.Player;

import Core.FrameCounter;
import Core.GameObject;
import Game.Player.Bullet.BulletPlayer;

public class PlayerShoot {
    private FrameCounter frameCounter = new FrameCounter(20);
    public void run(Player player){
        if (this.frameCounter.run()){
            BulletPlayer bulletPlayer = new BulletPlayer();
            bulletPlayer.position.set(player.position);
            bulletPlayer.velocity.set(0.0f,3.0f);
            GameObject.add(bulletPlayer);
            frameCounter.reset();
        }
    }
}
