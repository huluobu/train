package com.carrot.train;

import com.alibaba.druid.pool.DruidDataSource;

import com.alibaba.druid.pool.DruidPooledConnection;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

public class test {
    public static void main(String[] args) {
        ApplicationContext ctx= new ClassPathXmlApplicationContext("META-INF/spring/spring-jdbc.xml");
//        Object ob = ctx.getBean("film1");
//        Film film = ctx.getBean("film1",Film.class);
//        System.out.println(film);
        DruidDataSource dataSource = ctx.getBean(DruidDataSource.class);
        try {
            DruidPooledConnection connection = dataSource.getConnection();
            System.out.println(connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println();
    }
}
