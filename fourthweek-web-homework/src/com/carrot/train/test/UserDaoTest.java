package com.carrot.train.test;

import com.carrot.train.dao.UserDao;
import com.carrot.train.dao.impl.UserDaoImpl;
import com.carrot.train.enetity.User;

public class UserDaoTest {
    UserDao userDao = new UserDaoImpl();
    public void queryUserByUsername() {
        if (userDao.queryUserByUsername("admin1234") == null ){
            System.out.println("用户名可用！ ");
        } else {
            System.out.println("用户名已存在！ ");
        }
    }
    public void queryUserByUsernameAndPassword() {
        if ( userDao.queryUserByUsernameAndPassword("admin","admin1234") == null) {
            System.out.println("用户名或密码错误， 登录失败");
        } else {
            System.out.println("查询成功");
        }
    }
    public void saveUser() {
        System.out.println( userDao.saveUser(new User(null,"wzg168", "123456", "wzg168@qq.com")) );
    }
}
