import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class gameWindow extends JFrame{

    gameCanvas gameCanvas;
    private long lasttime=0;
    public gameWindow(){
        this.setSize(400,650);
        this.setupGameCanvas();
        this.setVisible(true);
        this.event();
    }
    private void setupGameCanvas(){
        this.gameCanvas = new gameCanvas();
        this.add(this.gameCanvas);
    }
    private void event(){
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                gameCanvas.positionPlayerX = e.getX();
                gameCanvas.positionPlayerY = e.getY();
            }
        });
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(1);
            }
        });
    }
    public void gameLoop(){
        while (true){
            //this.run();
            long currentTime = System.nanoTime();
            if (currentTime-this.lasttime>=17_000_000){//cách viết của 17 triệu nano giây
                this.gameCanvas.renderAll();
                this.lasttime=currentTime;
            }
            gameCanvas.repaint();
        }
    }
}
