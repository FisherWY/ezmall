package com.dao;

import com.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/4 10:08 上午
 */

@Repository("userDao")
@Mapper
public interface UserDao {
    public List<User> selectUserByUsername(User user);

    public List<User> verifyUser(User user);

    public boolean addUser(User user);
}
