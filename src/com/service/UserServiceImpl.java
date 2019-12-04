package com.service;

import com.dao.UserDao;
import com.po.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/4 10:10 上午
 */

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public List<User> selectUserByUsername(User user) {
        return userDao.selectUserByUsername(user);
    }
}
