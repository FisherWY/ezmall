package com.service;

import com.po.User;

import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/4 10:09 上午
 */

public interface UserService {
    public List<User> selectUserByUsername(User user);
}
