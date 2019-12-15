package com.service;

import com.po.*;

import java.util.List;
import java.util.Map;

/**
 * @Author: Fisher
 * @Date: 2019/12/14 10:42 上午
 */

public interface OrderService {
    public boolean addOrder(Order order, List<OrderItem> list);

    public List<OrderInfo> findOrderByUserId(int id);

}
