package v9;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* day 2:
5. 增加子弹类 bullet
    增加moving 属性
*
* */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TestFrame tf = new TestFrame();
        while(true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}