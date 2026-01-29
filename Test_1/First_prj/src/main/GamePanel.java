package main;

import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.Color;


public class GamePanel extends JPanel implements Runnable{
    // SCREEN SETTINGS
    final int originalTitlesize = 16;
    final int scale = 3;

    final int titleSize = originalTitlesize * scale;
    final int maxScreenCol = 16;
    final int maxScreenRow = 12;
    final int screenWidth = titleSize * maxScreenCol; // 768 pixels
    final int screenHeight = titleSize * maxScreenRow; // 576 pixels

    Thread gameThread;


    public GamePanel() {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }
    public void run() {
        while(gameThread != null){
            System.out.println("Game Loop is running");
        }
    }
}
