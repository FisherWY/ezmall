package com.service;

import com.dao.ProductDao;
import com.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

/**
 * @Author: Fisher
 * @Date: 2019/12/13 9:12 上午
 */

@Service("cartService")
@Transactional
public class CartServiceImpl implements CartService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product addToCart(String pid, Integer buyNum) {
        List<Product> res = productDao.selectProductByPid(pid);
        if (res.size() > 0 && res.get(0).getPnum() > buyNum) {
            return res.get(0);
        } else {
            return new Product();
        }
    }

    @Override
    public Product getProduct(String pid) {
        List<Product> res = productDao.selectProductByPid(pid);
        return res.get(0);
    }
}
