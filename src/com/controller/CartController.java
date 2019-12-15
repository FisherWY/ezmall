package com.controller;

import com.po.Product;
import com.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @Author: Fisher
 * @Date: 2019/12/13 9:11 上午
 */

@Controller
@RequestMapping("/cart")
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping(value = "/addToCart")
    public String addToCart(HttpSession httpSession, HttpServletRequest request) {
        String pid = request.getParameter("pid");
        Integer buyNum = Integer.parseInt(request.getParameter("buyNum"));
        Map<Product, Integer> cartMap = (Map<Product, Integer>) httpSession.getAttribute("cartmap");
        Product product = cartService.addToCart(pid, buyNum);
        if (cartMap.containsKey(product)) {
            if (buyNum < 0) {
                cartMap.remove(product);
            } else {
                cartMap.put(product, cartMap.get(product) + buyNum);
            }
        } else {
            cartMap.put(product, buyNum);
        }
        return "cart";
    }

    @RequestMapping("/updateBuyNum")
    public void updateBuyNum(HttpSession httpSession, HttpServletRequest request) {
        String pid = request.getParameter("pid");
        Integer buyNum = Integer.parseInt(request.getParameter("buyNum"));
        Map<Product, Integer> cartMap = (Map<Product, Integer>) httpSession.getAttribute("cartmap");
        Product product = cartService.getProduct(pid);
        if (buyNum < 0) {
            cartMap.remove(product);
        } else {
            cartMap.put(product, buyNum);
        }
        httpSession.removeAttribute("cartmap");
        httpSession.setAttribute("cartmap", cartMap);
    }
}
