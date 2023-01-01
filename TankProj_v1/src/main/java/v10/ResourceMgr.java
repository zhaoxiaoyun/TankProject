package v10;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * @author: zxy
 * @date: 2022/12/31 - 17:04
 * @description: v10
 * @version: 1.0
 */

/*
* 加载静态资源
* */
public class ResourceMgr {
    public static BufferedImage tankL, tankD, tankR, tankU;
    public static BufferedImage bulletL, bulletD, bulletR, bulletU;
    public static BufferedImage[] explodes = new BufferedImage[16];
    static{
        try{
            //加载坦克图片
            tankL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankL.gif"));
            tankD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankD.gif"));
            tankR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankR.gif"));
            tankU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/tankU.gif"));
            //加载子弹图片
            bulletL = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletL.gif"));
            bulletD = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletD.gif"));
            bulletR = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletR.gif"));
            bulletU = ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/bulletU.gif"));
            //加载爆炸效果
            for(int i = 0; i<16; i++){
                explodes[i]=ImageIO.read(ResourceMgr.class.getClassLoader().getResourceAsStream("images/e"+(i+1)+".gif"));
            }
        }catch(IOException e) {
            e.printStackTrace();
        }
    }
}