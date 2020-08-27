package com.carrot.train.config;

import jdk.internal.util.xml.impl.Input;
import sun.misc.ObjectInputFilter;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: carrot
 * @Date: 2020/8/27 14:02
 * @Description:
 */
public class config {
    private static Properties properties = new Properties();

    static {
        InputStream inputStream = config.class.getClassLoader().getResourceAsStream("server.properties");
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
/*    InputStream inputStream = config.class.getClassLoader().getResourceAsStream("server.properties");
    properties.load(inputStream);*/
/**
 * @deprecated 获取properties文件的值
 * @author carrot
 * @date 2020/8/27
 * @param: null
 * @return
 **/
    public   String getPro(String key){
        return properties.getProperty(key);
    }
//    public static void main(String[] args) {
//        System.out.println(getPro("servvername"));
//    }

}
