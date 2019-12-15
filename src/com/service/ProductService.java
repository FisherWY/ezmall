package com.service;

import com.po.Product;

import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/13 11:04 上午
 */

public interface ProductService {
    public List<Product> getAllProduct();

    public String getProductImg(String imgUrl);

    public List<Product> searchProduct(Product product);

    public Product getProductByPid(String pid);
}
