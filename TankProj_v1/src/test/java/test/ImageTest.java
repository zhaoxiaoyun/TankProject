package test;

import org.junit.Assert;
import org.junit.Test;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author: zxy
 * @date: 2022/12/31 - 18:43
 * @description: test
 * @version: 1.0
 */
public class ImageTest {
    @Test
    public void test(){
        System.out.println("test input image..");
        Assert.assertNotNull(new Object());
    }

    @Test
    public void imageLoadTest(){
        String file_name = "images/tankD.gif";
        InputStream is = ImageTest.class.getClassLoader().getResourceAsStream(file_name);
        try {
            BufferedImage image = ImageIO.read(is);
            Assert.assertNotNull(image);
            System.out.println("image width: " + image.getWidth());
            System.out.println("image height: " + image.getHeight());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}