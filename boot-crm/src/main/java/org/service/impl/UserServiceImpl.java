package org.service.impl;

import org.dao.UserMapper;
import org.po.User;
import org.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    //注入UserMapper
    @Autowired
    private UserMapper userMapper;
    //通过账号和密码查询用户
    @Override
    public User findUser(String usercode, String password) {
        User user=this.userMapper.findUser(usercode,password);
        return user;
    }
}
