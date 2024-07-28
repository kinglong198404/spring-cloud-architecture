package com.klfront.klblog.dataprovider.service;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.klfront.klblog.dataprovider.mapper.UserMapper;
import com.klfront.klblog.common.entity.User;
import com.klfront.klblog.dataprovider.service.impl.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public int insertSelective(User record) {
        return userMapper.insertSelective(record);
    }

    @Override
    public User selectByPrimaryKey(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

}




