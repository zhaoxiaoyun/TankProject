package v2;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

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
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        g.fillRoundRect(x,y,50,50,20,40);
        //x+=50;
        //y+=50;
    }

    private class MyKeyListener extends KeyAdapter{
        @Override
        public void keyPressed(KeyEvent e) {
            System.out.println("key pressed");
            x+=50;
            y+=50;
            repaint();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            System.out.println("key released");
        }
    }
}