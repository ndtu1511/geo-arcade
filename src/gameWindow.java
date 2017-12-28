import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class gameWindow extends JFrame{

    gameCanvas gameCanvas;
    private long lasttime=0;
    public gameWindow(){
        this.setSize(419,648);
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
            long currentTime = System.nanoTime();
            if (currentTime-this.lasttime>=17_000_000){
                // uncomment bai 1 va 2 va comment bai 3 de xem bai 1 va 2
//                this.gameCanvas.enemy1.btap1();
//                this.gameCanvas.enemy2.btap2();
                for (int i=0;i<gameCanvas.sizeBT3;i++) {
                    this.gameCanvas.enemy3[i].btap1();
                }
                this.gameCanvas.renderAll();
                this.lasttime=currentTime;
            }
        }
    }
}
