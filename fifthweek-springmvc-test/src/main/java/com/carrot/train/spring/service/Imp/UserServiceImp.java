package com.carrot.train.spring.service.Imp;

import com.carrot.train.spring.enetity.User;
import com.carrot.train.spring.mapper.UsersMapper;
import com.carrot.train.spring.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImp implements UserService {
    @Autowired
    private UsersMapper usersMapper;


}
