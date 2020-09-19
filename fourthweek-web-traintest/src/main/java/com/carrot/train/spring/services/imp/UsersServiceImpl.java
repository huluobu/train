package com.carrot.train.spring.services.imp;


import com.carrot.train.spring.mapper.UsersMapper;
import com.carrot.train.spring.services.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Lance
 * @create: 2020-09-19
 **/
@Service
public class UsersServiceImpl implements UsersService {
    @Autowired
    private UsersMapper usersMapper;

    @Override
    public void update(Object object) {
        usersMapper.update(object);
    }

    @Override
    public void insert(Object object) {
        usersMapper.insert(object);
    }

    @Override
    public Object findByPrimaryKey(Object primaryKey) {
        return usersMapper.findByPrimaryKey(primaryKey);
    }
}
