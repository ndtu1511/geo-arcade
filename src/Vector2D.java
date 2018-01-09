public class Vector2D {
    public float x;
    public float y;
    public Vector2D(){
     this.x = 0.0f;
     this.x = 0.0f;
    }
    public Vector2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    public Vector2D set(float x, float y){
        this.x = x;
        this.y = y;
        return this;
    }
    public Vector2D set(Vector2D vector2D){
        return this.set(vector2D.x,vector2D.y);
    }
    public Vector2D addUp(float x, float y){
        this.x +=x;
        this.y +=y;
        return this;
    }
    public Vector2D addUp(Vector2D vector2D){
        return this.addUp(vector2D.x,vector2D.y);
    }
    public Vector2D add(float x, float y){
        return new Vector2D(this.x + x, this.y +y);
    }
    public Vector2D add(Vector2D vector2D){
        return this.add(vector2D.x,vector2D.y);
    }
    public Vector2D subtractBy(float x, float y){
        this.x -=x;
        this.y -=y;
        return this;
    }
    public Vector2D subtractBy(Vector2D vector2D){
        return this.subtractBy(vector2D.x,vector2D.y);
    }
    public Vector2D subtract(float x, float y){
        return new Vector2D(this.x -x,this.y -y );
    }
    public Vector2D subtract(Vector2D vector2D){
        return this.subtract(vector2D.x,vector2D.y);
    }
    public float length(){
        return (float)Math.sqrt(this.x*this.x + this.y*this.y);
    }
    public Vector2D clone(){
        return new Vector2D(this.x,this.y);
    }
    public Vector2D multiply(float number){
        this.x *= number;
        this.y *= number;
        return this;
    }
    public Vector2D normalize(){
        if(length()!=0) {
            this.x = this.x / this.length();
            this.y = this.y / this.length();
        }
        return this;
    }
    public Vector2D rotate(int degree, Vector2D axis){
        double angle =Math.toRadians(degree);
        this.subtractBy(axis);
        float x=(float) (this.x*Math.cos(angle)-this.y*Math.sin(angle));
        float y=(float) (this.x*Math.sin(angle)+this.y*Math.cos(angle));
        this.x = x+axis.x;
        this.y = y+axis.y;
        return this;
    }
}
