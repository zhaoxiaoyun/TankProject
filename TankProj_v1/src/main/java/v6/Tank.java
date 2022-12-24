package v6;

import java.awt.*;

/**
 * @author: zxy
 * @date: 2022/12/24 - 12:03
 * @description: v6
 * @version: 1.0
 */
public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED=10;
    public Tank(int x, int y, Dir dir){
        this.x = x;
        this.y = y;
        this.dir = dir;
    }

    public Dir getDir() {
        return dir;
    }

    public void setDir(Dir dir) {
        this.dir = dir;
    }

    public void paint(Graphics g) {
        g.fillRoundRect(x,y,50,50,20,40);
        if(dir== Dir.LEFT) x-=SPEED;
        if(dir== Dir.UP) y-=SPEED;
        if(dir== Dir.RIGHT) x+=SPEED;
        if(dir== Dir.DOWN) y+=SPEED;
    }
}