package v12;

import java.io.IOException;
import java.util.Properties;

/**
 * @author: zxy
 * @date: 2023/1/2 - 23:21
 * @description: v12
 * @version: 1.0
 */
public class PropertyMgr extends Properties {
    static Properties props = new Properties();
    static{
        try {
            props.load(PropertyMgr.class.getClassLoader().getResourceAsStream("config"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Object get(String key){
        if(props==null) return null;
        return props.get(key);
    }
}
