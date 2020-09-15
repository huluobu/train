package com.carrot.train.utils;

import java.sql.Connection;

public class test01 {
    public static void main(String[] args) {
        for (int i = 0; i < 5; i++){
            Connection connection = JdbcUtils.getConnection();
            System.out.println(connection);
            JdbcUtils.close(connection);
        }
    }
}
