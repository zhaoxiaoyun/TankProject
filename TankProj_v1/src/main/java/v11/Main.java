package v11;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* day 3:
10. 增加explodes；坦克分群，队友无伤害；坦克随机fire
* 将爆炸放到 坦克消失的位置
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