package com.carrot.train.spring.services.imp;

import com.carrot.train.spring.mapper.StaffMapper;
import com.carrot.train.spring.services.StaffService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @description:
 * @author: Lance
 * @create: 2020-09-19
 **/
@Service
public class StaffServiceImpl implements StaffService {

    @Autowired
    private StaffMapper staffMapper;

    @Override
    public void update(Object object) {
        staffMapper.update(object);
    }

    @Override
    public void insert(Object object) {
        staffMapper.insert(object);
    }

    @Override
    public Object findByPrimaryKey(Object primaryKey) {
        return staffMapper.findByPrimaryKey(primaryKey);
    }
}
