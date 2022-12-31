package v9;

import java.awt.*;

/**
 * @author: zxy
 * @date: 2022/12/24 - 17:48
 * @description: v8
 * @version: 1.0
 */
public class Bullet {
    private final static int SPEED = 10;
    private final static int WIDTH = 5;
    private final static int HEIGHT = 5;
    private int x,y;
    private Dir dir;
    private boolean living=true;
    private TankFrame tf=null;

    public Bullet(int x, int y, Dir dir, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.tf = tf;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g){
        Color color = g.getColor();
        g.setColor(Color.RED);
        g.fillOval(x,y, WIDTH,HEIGHT);
        g.setColor(color);
        move();
        if(!living) tf.bullets.remove(this);
    }

    private void move() {
        if(dir== Dir.LEFT) x-=SPEED;
        if(dir== Dir.UP) y-=SPEED;
        if(dir== Dir.RIGHT) x+=SPEED;
        if(dir== Dir.DOWN) y+=SPEED;

        if(x<0||y<0||x>TankFrame.GAME_WIDTH||y>TankFrame.GAME_HEIGHT) living=false;
    }
}