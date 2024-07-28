package com.klfront.klblog.dataprovider.service.impl;

import com.klfront.klblog.common.entity.User;
public interface UserService{


    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(User record);

}
