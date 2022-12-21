package v1;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * @author: zxy
 * @date: 2022/12/19 - 23:47
 * @description: PACKAGE_NAME
 * @version: 1.0
 */
public class T {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(800,600);
        frame.setResizable(false);
        frame.setTitle("tank war");
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
