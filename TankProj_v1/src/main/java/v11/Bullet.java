package v11;

import java.awt.*;

/**
 * @author: zxy
 * @date: 2022/12/24 - 17:48
 * @description: v8
 * @version: 1.0
 */
public class Bullet {
    private final static int SPEED = 10;
    private int x,y;
    private Dir dir;
    private boolean living=true;
    private TankFrame tf=null;
    private Group group = Group.BAD;

    public Bullet(int x, int y, Dir dir, Group group,TankFrame tf){
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

    public void paint(Graphics g){
        if(dir== Dir.LEFT) g.drawImage(ResourceMgr.bulletL,x,y,null);
        if(dir== Dir.UP) g.drawImage(ResourceMgr.bulletU,x,y,null);
        if(dir== Dir.RIGHT) g.drawImage(ResourceMgr.bulletR,x,y,null);
        if(dir== Dir.DOWN) g.drawImage(ResourceMgr.bulletD,x,y,null);

        move();
        if(!living) tf.bullets.remove(this);
    }

    private void move() {
        if(dir== Dir.LEFT) x-=SPEED;
        if(dir== Dir.UP) y-=SPEED;
        if(dir== Dir.RIGHT) x+=SPEED;
        if(dir== Dir.DOWN) y+=SPEED;

        if(x<0||y<0||x> TankFrame.GAME_WIDTH||y> TankFrame.GAME_HEIGHT) living=false;
    }

    public void collideWith(Tank tank) {
        if(this.group==tank.getGroup()) return;

        //?每次碰撞都会 new Rectangle，内存占用问题；用1个rect 记录子弹位置
        Rectangle tankRect, bulletRect;
        if(dir== Dir.DOWN){
            bulletRect = new Rectangle(x,y, ResourceMgr.bulletD.getWidth(), ResourceMgr.bulletD.getHeight());
        }else if(dir== Dir.LEFT){
            bulletRect = new Rectangle(x,y, ResourceMgr.bulletL.getWidth(), ResourceMgr.bulletL.getHeight());
        }else if(dir== Dir.UP){
            bulletRect = new Rectangle(x,y, ResourceMgr.bulletU.getWidth(), ResourceMgr.bulletU.getHeight());
        }else{
            bulletRect = new Rectangle(x,y, ResourceMgr.bulletR.getWidth(), ResourceMgr.bulletR.getHeight());
        }

        tankRect = new Rectangle(tank.getX(), tank.getY(), ResourceMgr.tankD.getWidth(), ResourceMgr.tankD.getHeight());

        if(bulletRect.intersects(tankRect)){
            tank.die();
            this.die();
        }
    }

    private void die() {
        this.setLiving(false);
    }
}