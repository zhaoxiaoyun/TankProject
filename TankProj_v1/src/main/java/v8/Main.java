package v8;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* day 2:
7. 使用双缓冲消除 屏幕闪烁
* 8. 按ctrl 打出一发子弹
*
* */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        TankFrame tf = new TankFrame();
        while(true){
            Thread.sleep(100);
            tf.repaint();
        }
    }
}