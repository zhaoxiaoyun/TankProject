package v3;

/**
 * @author: zxy
 * @date: 2022/12/23 - 17:25
 * @description: v2
 * @version: 1.0
 */

/*
* 通过thread repaint 移动
*   repaint 默认调用paint
* 键盘监听 esc 退出
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