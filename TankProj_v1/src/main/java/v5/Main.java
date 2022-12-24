package v5;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* day 2:
* 1. 如何定义主战坦克方向
    Enum Dir
2. 根据按键改变主战坦克方向
    setMainTankDir()
3. 根据方向进行坦克移动
*
* */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestFrame tf = new TestFrame();
        while(true){
            Thread.sleep(100);
            tf.repaint();
            System.out.println("moving...");
        }
    }
}