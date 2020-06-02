package org.service;

import org.po.User;

public interface UserService {
    public User findUser(String usercode,String password);
}
