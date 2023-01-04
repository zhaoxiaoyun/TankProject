package v12;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* day 4:

*
* */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //加入敌军坦克
        for(int i =0; i<5;i++){
            tf.tanks.add(new Tank(30+i*100, 150, Dir.DOWN, Group.BAD, tf));
        }
        
        while(true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}