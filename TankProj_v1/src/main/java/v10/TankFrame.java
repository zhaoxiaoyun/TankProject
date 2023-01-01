package v10;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:24
 * @description: v2
 * @version: 1.0
 */
public class TankFrame extends Frame {
    Tank myTank = new Tank(350,250, Dir.DOWN,this);
    List<Tank> tanks = new ArrayList<>();
    //Bullet bullet = new Bullet(400, 300, Dir.DOWN);
    List<Bullet> bullets = new ArrayList<>();
    public static final int GAME_WIDTH = 800;
    public static final int GAME_HEIGHT = 600;

    public TankFrame(){//构造 画布显示、格式 对键盘、鼠标、屏幕监听
        this.setVisible(true);
        this.setSize(GAME_WIDTH,GAME_HEIGHT);
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

//    使用双缓冲 消除闪烁
    Image offScreenImage = null;
    @Override
    public void update(Graphics g) {// 置于paint前, 每隔100ms 调用repaint-调用update-paint
        if(offScreenImage==null){
            offScreenImage = this.createImage(GAME_WIDTH, GAME_HEIGHT);
        }
        Graphics gOffScreen = offScreenImage.getGraphics();
        Color c = gOffScreen.getColor();
        gOffScreen.setColor(Color.BLACK);
        gOffScreen.fillRect(0,0,GAME_WIDTH,GAME_HEIGHT);
        gOffScreen.setColor(c);
        paint(gOffScreen);
        g.drawImage(offScreenImage, 0, 0, null);
    }

    @Override
    public void paint(Graphics g) {
        Color color = g.getColor();
        g.setColor(Color.white);
        g.drawString("bullets: " + bullets.size(),10,60);
        g.drawString("enemies: " + tanks.size(),10,80);
        g.setColor(color);

        myTank.paint(g);

        for(int i =0;i<tanks.size();i++){
            tanks.get(i).paint(g);
        }

        //bullet.paint(g);
        //for(Bullet b: bullets){b.paint(g);} //不能删除 使用iterator迭代时

        for(int i=0; i<bullets.size();i++){
            bullets.get(i).paint(g);
        }

        //子弹、坦克 碰撞后消失
        for(int b = 0; b<bullets.size(); b++){
            for(int t = 0; t<tanks.size(); t++){
                bullets.get(b).collideWith(tanks.get(t));
            }
        }
    }

    private class MyKeyListener extends KeyAdapter{
        //设置方向
        Boolean bL = false;
        Boolean bU = false;
        Boolean bR = false;
        Boolean bD = false;
        @Override
        public void keyPressed(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_ESCAPE:
                    System.exit(0);
                    break;
                case KeyEvent.VK_LEFT:
                    bL = true;
                    break;
                case KeyEvent.VK_UP:
                    bU = true;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = true;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = true;
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        @Override
        public void keyReleased(KeyEvent e) {
            int key = e.getKeyCode();
            switch (key){
                case KeyEvent.VK_LEFT:
                    bL = false;
                    break;
                case KeyEvent.VK_UP:
                    bU = false;
                    break;
                case KeyEvent.VK_RIGHT:
                    bR = false;
                    break;
                case KeyEvent.VK_DOWN:
                    bD = false;
                    break;
                case KeyEvent.VK_SPACE:
                    myTank.fire();
                    break;
                default:
                    break;
            }
            setMainTankDir();
        }

        private void setMainTankDir() {
            if(!bL && !bU && !bR && !bD) {
                myTank.setMoving(false);
            }else{
                myTank.setMoving(true);
                if(bL) myTank.setDir(Dir.LEFT);
                if(bU) myTank.setDir(Dir.UP);
                if(bR) myTank.setDir(Dir.RIGHT);
                if(bD) myTank.setDir(Dir.DOWN);
            };
        }
    }
}