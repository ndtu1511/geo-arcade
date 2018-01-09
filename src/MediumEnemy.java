public class MediumEnemy extends Enemy {
    private int count =0;
    public MediumEnemy() {
        this.velocity = new Vector2D();
        this.image = Utils.loadImage("resources/square/enemy_square_medium.png");
    }

    @Override
    public void run() {
        super.run();
        if (this.count==50){
            BulletEnemy bulletEnemy = new BulletEnemy();
            bulletEnemy.position.set(this.position);
            bulletEnemy.velocity.set(0.0f,3.0f);
            GameObject.add(bulletEnemy);
            this.count=0;
        }
        else{
            count++;
        }
    }
}
