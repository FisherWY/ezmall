package com.dao;

import com.po.Order;
import com.po.OrderItem;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/14 10:48 上午
 */

@Repository("orderDao")
@Mapper
public interface OrderDao {
    public boolean addOrder(Order order);

    public boolean addOrderItem(OrderItem item);

    public List<Order> findOrderByUserId(int id);

    public List<OrderItem> findOrderItemByOrderId(String id);
}
