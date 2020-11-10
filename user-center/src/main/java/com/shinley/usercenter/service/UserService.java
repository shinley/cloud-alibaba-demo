package com.shinley.usercenter.service;

import com.shinley.usercenter.dao.UserMapper;
import com.shinley.usercenter.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    public User findById(Integer id) {
        return this.userMapper.selectByPrimaryKey(id);
    }

    public void insertSelective(User user) {
        this.userMapper.insertSelective(user);
    }
}
