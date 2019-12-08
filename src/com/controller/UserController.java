package com.controller;

import com.po.User;
import com.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/8 10:53 上午
 */

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user, Model model, HttpSession session) {
        List<User> res = userService.verifyUser(user);
        if (res.size() != 0) {
            // 登录成功，添加session和成功消息
            session.setAttribute("user", res.get(0));
            model.addAttribute("msg", "登录成功，跳转到首页！");
            return "index";
        } else {
            // 登录失败，只添加失败消息
            model.addAttribute("msg", "登录失败，用户名或密码错误！");
            return "login";
        }
    }

    @RequestMapping(value = "/regist", method = RequestMethod.POST)
    public String regist(User user, Model model, HttpSession session) {
        // 输入的密码不一致
        if (!user.getPassword().equals(user.getPassword2())) {
            model.addAttribute("m", 0);
            model.addAttribute("msg", "两次密码不一致！");
            return "regist";
        }
        // 用户名已被抢注
        if (userService.selectUserByUsername(user).size() != 0) {
            model.addAttribute("m", 0);
            model.addAttribute("msg", "用户名已被注册！");
            return "regist";
        }
        // 添加用户成功，跳转到首页
        if (userService.addUser(user)) {
            model.addAttribute("m", 1);
            model.addAttribute("msg", "注册成功！");
            session.setAttribute("user", user);
            return "index";
        } else {
            // 添加失败
            model.addAttribute("m", 0);
            model.addAttribute("msg", "注册失败，内部错误！");
            return "regist";
        }
    }
}
