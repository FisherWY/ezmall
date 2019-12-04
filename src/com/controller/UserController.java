package com.controller;

import com.po.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/4 10:11 上午
 */

@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("/select")
    public String select(User user, Model model) {
        List<User> list = userService.selectUserByUsername(user);
        model.addAttribute("userList", list);
        return "userList";
    }
}
