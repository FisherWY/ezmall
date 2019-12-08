package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @Author: Fisher
 * @Date: 2019/12/7 9:34 下午
 */

@Controller
@RequestMapping("/index")
public class IndexController {

    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    @RequestMapping("/register")
    public String register() {
        return "regist";
    }

    @RequestMapping("/exit")
    public String exit(HttpSession session) {
        // 移除session并刷新主页
        session.removeAttribute("user");
        return "index";
    }
}
