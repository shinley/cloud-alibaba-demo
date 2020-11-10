package com.shinley.usercenter.controller;

import com.shinley.usercenter.dao.UserMapper;
import com.shinley.usercenter.entity.User;
import com.shinley.usercenter.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public User findById(@PathVariable Integer id) {
        return this.userService.findById(id);
    }

    @GetMapping("/test")
    public User testInsert() {
        User user = new User();
        user.setAvatrUrl("xxx");
        user.setBonus(100);
        user.setCreateTime(new Date());
        user.setUpdateTime(new Date());
        userService.insertSelective(user);
        return user;
    }
}
