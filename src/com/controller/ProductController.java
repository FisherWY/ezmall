package com.controller;

import com.dao.ProductDao;
import com.po.Product;
import com.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public void searchProd(HttpServletRequest request) {
        String name = request.getParameter("name");
        String category = request.getParameter("category");
        Product product = new Product();
        product.setName(name);
        product.setCategory(category);
        List<Product> list = productService.searchProduct(product);
        request.setAttribute("productList", list);
    }
}
