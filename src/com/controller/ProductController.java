package com.controller;

import com.dao.ProductDao;
import com.po.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * @Author: Fisher
 * @Date: 2019/12/13 10:20 上午
 */

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping("/getProdList")
    public String getProdList(HttpSession httpSession) {
        List<Product> products = productService.getAllProduct();
        httpSession.setAttribute("productList", products);
        return "prod_list";
    }

    @RequestMapping("/getProdImg")
    public String getProdImg(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException {
        String url = productService.getProductImg(request.getParameter("imgurl"));
        return url;
    }

    @RequestMapping("/getProdinfo")
    public String getProdinfo(HttpServletRequest request) {
        String pid = request.getParameter("pid");
        Product res = productService.getProductByPid(pid);
        request.setAttribute("prod", res);
        return "prod_info";
    }

    @RequestMapping("/searchProd")
    public String searchProd(HttpServletRequest request, HttpSession httpSession) {
        Product product = new Product();
        if (!StringUtils.isEmpty(request.getParameter("name"))) {
            product.setName(request.getParameter("name"));
        } else {
            product.setName("");
        }
        if (!StringUtils.isEmpty(request.getParameter("category"))) {
            product.setCategory(request.getParameter("category"));
        } else {
            product.setCategory("");
        }
        if (!StringUtils.isEmpty(request.getParameter("minprice"))) {
            Double minprice = Double.parseDouble(request.getParameter("minprice"));
            product.setPrice(minprice);
        } else {
            product.setPrice(Double.MIN_VALUE);
        }
        if (!StringUtils.isEmpty(request.getParameter("maxprice"))) {
            Double maxprice = Double.parseDouble(request.getParameter("maxprice"));
            product.setPrice1(maxprice);
        } else {
            product.setPrice1(Double.MAX_VALUE);
        }
        List<Product> list = productService.searchProduct(product);
        httpSession.setAttribute("productList", list);
        return "prod_list";
    }

    @RequestMapping("/searchProdByName")
    public String searchProdByName(HttpServletRequest request, HttpSession httpSession) {
        Product product = new Product();
        if (!StringUtils.isEmpty(request.getParameter("name"))) {
            product.setName(request.getParameter("name"));
        } else {
            product.setName("");
        }
        List<Product> list = productService.searchProduct(product);
        httpSession.setAttribute("productList", list);
        return "prod_list";
    }
}
