package v6;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* day 2:
4. 想象如何给出更多坦克 及 子弹
    将坦克封装成类，理解面向对象中 “封装”思想
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