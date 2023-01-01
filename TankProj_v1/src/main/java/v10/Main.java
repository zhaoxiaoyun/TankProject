package v10;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* day 3:
10. 增加坦克、子弹图片
*   类加载器
*
* */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();

        //加入敌军坦克
        for(int i =0; i<5;i++){
            tf.tanks.add(new Tank(30+i*100, 150, Dir.DOWN, tf));
        }
        
        while(true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}