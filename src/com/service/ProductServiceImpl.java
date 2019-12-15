package com.service;

import com.dao.ProductDao;
import com.po.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/13 11:07 上午
 */

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> getAllProduct() {
        return productDao.getAllProduct();
    }

    @Override
    public String getProductImg(String imgUrl) {
        return imgUrl.substring(0,8);
    }

    @Override
    public List<Product> searchProduct(Product product) {
        return productDao.searchProduct(product);
    }

    @Override
    public Product getProductByPid(String pid) {
        List<Product> list = productDao.selectProductByPid(pid);
        return list.get(0);
    }
}
