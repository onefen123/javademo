package com.zsgc.service;


import com.zsgc.entity.User;
import com.zsgc.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    public int addUser(User user) {
        return userMapper.save(user);
    }


    public User checkUser(User user) {
        return userMapper.checkUser(user.getName());

    }
}
