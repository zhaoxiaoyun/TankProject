package v3;

import java.awt.*;
import java.awt.event.*;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:24
 * @description: v2
 * @version: 1.0
 */
public class TestFrame extends Frame {
    int x = 350;
    int y = 250;

    public TestFrame(){
        this.setVisible(true);
        this.setSize(800,600);
        this.setTitle("Test Frame");
        this.setResizable(false);
        this.addKeyListener(new MyKeyListener());
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.out.println("closing window...");
                System.exit(0);
            }
        });
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("mouse clicked...");
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRoundRect(x,y,50,50,20,40);
        x+=1;
        y+=1;
    }

    private class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode() == KeyEvent.VK_ESCAPE) System.exit(0);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            super.keyReleased(e);
        }
    }
}