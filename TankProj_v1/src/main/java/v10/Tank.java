package v10;

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
    private static final int SPEED=5;
    private boolean moving = false;
    private boolean living = true;
    private TankFrame tf = null;

    public Tank(int x, int y, Dir dir, TankFrame tf){
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

    public boolean isLiving() {
        return living;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void paint(Graphics g) {
        if(!living){
            tf.tanks.remove(this);
            return;
        }
        if(dir==Dir.LEFT) g.drawImage(ResourceMgr.tankL,x,y,null);
        if(dir==Dir.UP) g.drawImage(ResourceMgr.tankU,x,y,null);
        if(dir==Dir.RIGHT) g.drawImage(ResourceMgr.tankR,x,y,null);
        if(dir==Dir.DOWN) g.drawImage(ResourceMgr.tankD,x,y,null);

        move();
    }

    private void move() {
        if(!moving) return;
        if(dir== Dir.LEFT) x-=SPEED;
        if(dir== Dir.UP) y-=SPEED;
        if(dir== Dir.RIGHT) x+=SPEED;
        if(dir== Dir.DOWN) y+=SPEED;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void fire() {
        int w,h;
        if(dir==Dir.DOWN || dir==Dir.UP){
            w = this.x + ResourceMgr.tankD.getWidth()/2 - ResourceMgr.bulletD.getWidth()/2;
            h = this.y + ResourceMgr.tankD.getHeight()/2 - ResourceMgr.bulletD.getHeight()/2;
        }else{
            w = this.x + ResourceMgr.tankL.getWidth()/2 - ResourceMgr.bulletL.getWidth()/2;
            h = this.y + ResourceMgr.tankL.getHeight()/2 - ResourceMgr.bulletL.getHeight()/2;
        }
        tf.bullets.add(new Bullet(w, h, this.dir, this.tf));
    }

    public void die() {
        this.setLiving(false);
    }
}