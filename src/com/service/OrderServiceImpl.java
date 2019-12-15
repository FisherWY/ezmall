package com.service;

import com.dao.OrderDao;
import com.dao.ProductDao;
import com.po.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Fisher
 * @Date: 2019/12/14 10:42 上午
 */

@Service("orderService")
@Transactional
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private ProductDao productDao;

    @Override
    public boolean addOrder(Order order, List<OrderItem> list) {
        orderDao.addOrder(order);
        for (OrderItem x : list) {
            orderDao.addOrderItem(x);
        }
        return true;
    }

    @Override
    public List<OrderInfo> findOrderByUserId(int id) {
        List<OrderInfo> res = new ArrayList<>();
        List<Order> orderList = orderDao.findOrderByUserId(id);
        for (Order x : orderList) {
            List<OrderItem> itemList = orderDao.findOrderItemByOrderId(x.getId());
            Map<Product, Integer> map = new HashMap<Product, Integer>();
            for (OrderItem orderItem : itemList) {
                List<Product> productList = productDao.selectProductByPid(orderItem.getProduct_id());
                map.put(productList.get(0), orderItem.getBuynum());
            }
            OrderInfo orderInfo = new OrderInfo();
            orderInfo.setOrder(x);
            orderInfo.setMap(map);
            res.add(orderInfo);
        }
        return res;
    }
}
