package com.service;

import com.po.Product;

import java.util.Map;

/**
 * @Author: Fisher
 * @Date: 2019/12/13 9:12 上午
 */

public interface CartService {

    public Product addToCart(String pid, Integer buyNum);

    public Product getProduct(String pid);
}
