package com.carrot.train;


import com.carrot.train.config.config;

/**
 * @Author: carrot
 * @Date: 2020/8/27 14:47
 * @Description:
 */
public class test01 {
    public static void main(String[] args) {
        config con=new config();
        System.out.println(con.getPro("port"));
    }
}
