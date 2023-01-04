package v12;

import java.awt.*;
import java.util.Properties;
import java.util.Random;

/**
 * @author: zxy
 * @date: 2022/12/24 - 12:03
 * @description: v6
 * @version: 1.0
 */
public class Tank {
    private int x,y;
    private Dir dir = Dir.DOWN;
    private static final int SPEED= Integer.valueOf((String)PropertyMgr.get("tankSpeed"));
    private boolean moving = true;
    private boolean living = true;
    private TankFrame tf = null;
    private Group group = Group.BAD;
    private Random random = new Random();

    public Tank(int x, int y, Dir dir, Group group, TankFrame tf){
        this.x = x;
        this.y = y;
        this.dir = dir;
        this.group = group;
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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public boolean isMoving() {
        return moving;
    }

    public void setMoving(boolean moving) {
        this.moving = moving;
    }

    public void paint(Graphics g) {
        if(!living){
            tf.tanks.remove(this);
            return;
        }
        if(dir== Dir.LEFT) g.drawImage(ResourceMgr.tankL,x,y,null);
        if(dir== Dir.UP) g.drawImage(ResourceMgr.tankU,x,y,null);
        if(dir== Dir.RIGHT) g.drawImage(ResourceMgr.tankR,x,y,null);
        if(dir== Dir.DOWN) g.drawImage(ResourceMgr.tankD,x,y,null);
        move();
    }

    private void move() {
        if(!moving) return;
        if(dir== Dir.LEFT) x-=SPEED;
        if(dir== Dir.UP) y-=SPEED;
        if(dir== Dir.RIGHT) x+=SPEED;
        if(dir== Dir.DOWN) y+=SPEED;

        //tank一直fire
        if(random.nextInt(10)>8) this.fire();
    }

    public void fire() {
        int w,h;
        if(dir== Dir.DOWN || dir== Dir.UP){
            w = this.x + ResourceMgr.tankD.getWidth()/2 - ResourceMgr.bulletD.getWidth()/2;
            h = this.y + ResourceMgr.tankD.getHeight()/2 - ResourceMgr.bulletD.getHeight()/2;
        }else{
            w = this.x + ResourceMgr.tankL.getWidth()/2 - ResourceMgr.bulletL.getWidth()/2;
            h = this.y + ResourceMgr.tankL.getHeight()/2 - ResourceMgr.bulletL.getHeight()/2;
        }
        tf.bullets.add(new Bullet(w, h, this.dir, this.group, this.tf));
    }

    public void die() {
        this.setLiving(false);
    }
}