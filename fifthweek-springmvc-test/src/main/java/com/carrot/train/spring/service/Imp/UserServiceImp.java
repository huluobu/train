package com.carrot.train.spring.service.Imp;

import com.carrot.train.spring.enetity.User;
import com.carrot.train.spring.mapper.UsersMapper;
import com.carrot.train.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImp implements UserService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void registUser(User user) {

    }

    @Override
    public User login(User user) {
        return null;
    }

    @Override
    public boolean existsUsername(String username) {
        return false;
    }
}
