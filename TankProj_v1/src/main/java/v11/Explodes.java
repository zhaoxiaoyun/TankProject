package v11;

import java.awt.*;

/**
 * @author: zxy
 * @date: 2023/1/1 - 17:54
 * @description: v11
 * @version: 1.0
 */
public class Explodes {
    public static int WIDTH = ResourceMgr.explodes[0].getWidth();
    public static int HEIGHT = ResourceMgr.explodes[0].getHeight();

    private int x,y;
    private boolean living=true;
    private TankFrame tf=null;
    private int step = 0;

    public Explodes(int x, int y, TankFrame tf){
        this.x = x;
        this.y = y;
        this.tf = tf;
        //加入爆炸声音
        new Audio("audio/explode.wav").run();
    }

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public void paint(Graphics g){
        g.drawImage(ResourceMgr.explodes[step++], x,y,null);
        if(step>=ResourceMgr.explodes.length){
            tf.explodes.remove(this);
            step=0;
        }
    }
}
