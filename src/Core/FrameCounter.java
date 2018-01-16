package Core;

public class FrameCounter {
    public int count;
    public int max;

    public FrameCounter(int max) {
        this.max = max;
        this.count=0;
    }
    public boolean run(){
        if (this.count == this.max){
            return true;
        }
        else{
            this.count++;
            return false;
        }
    }
    public void reset(){
        this.count=0;
    }
}
