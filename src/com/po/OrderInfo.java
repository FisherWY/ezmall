package com.po;

import lombok.Data;

import java.util.Map;

/**
 * @Author: Fisher
 * @Date: 2019/12/14 11:42 上午
 */

@Data
public class OrderInfo {
    private Order order;
    private Map<Product, Integer> map;
}
