package com.carrot.train.dao;

import com.carrot.train.enetity.User;

public interface UserDao {

    public User queryUserByUsername(String username);

    public User queryUserByUsernameAndPassword(String username,String password);

    public int saveUser(User user);
}
