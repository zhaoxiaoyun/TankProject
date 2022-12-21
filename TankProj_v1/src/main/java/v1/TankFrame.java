package v1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: zxy
 * @date: 2022/12/21 - 0:08
 * @description: v1
 * @version: 1.0
 */

/*
* 继承Frame 重新
* */
public class TankFrame extends Frame {
    int x = 350;
    int y = 250;

    public TankFrame(){
        this.setSize(800,600);
        this.setResizable(false);
        this.setTitle("tank war");
        this.setVisible(true);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        System.out.println("paint");
        g.fill3DRect(x, y,100,100,true);
        x+=10;
        y+=10;
    }
}
