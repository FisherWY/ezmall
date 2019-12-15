package com.controller;

import com.po.*;
import com.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.*;

/**
 * @Author: Fisher
 * @Date: 2019/12/14 11:13 上午
 */

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @RequestMapping("/addOrder")
    public String addOrder(HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        Map<Product, Integer> map = (Map<Product, Integer>) session.getAttribute("cartmap");
        if (user == null) {
            return "login";
        } else {
            // 添加新订单
            Order order = new Order();
            order.setId(UUID.randomUUID().toString());
            order.setPaystate(0);
            order.setReceiverinfo(request.getParameter("receiverinfo"));
            order.setUser_id(user.getId());
            order.setOrdertime(new Date());

            // 添加新订单列表
            List<OrderItem> list = new ArrayList<>();
            double totalMoney = 0;
            for (Map.Entry<Product, Integer> entry : map.entrySet()) {
                double price = entry.getKey().getPrice();
                int buyNum = entry.getValue();
                totalMoney += price * buyNum;

                OrderItem item = new OrderItem();
                item.setOrder_id(order.getId());
                item.setProduct_id(entry.getKey().getId());
                item.setBuynum(buyNum);
                list.add(item);
            }
            order.setMoney(totalMoney);

            orderService.addOrder(order, list);
            map.clear();
            return "index";
        }
    }

    @RequestMapping("/orderList")
    public String orderList(HttpSession session, HttpServletRequest request) {
        User user = (User) session.getAttribute("user");
        if (user == null) {
            return "login";
        } else {
            List<OrderInfo> list = orderService.findOrderByUserId(user.getId());
            session.setAttribute("list", list);
            return "order_list";
        }
    }
}
