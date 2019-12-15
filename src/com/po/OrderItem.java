package com.po;

import lombok.Data;

/**
 * @Author: Fisher
 * @Date: 2019/12/14 11:07 上午
 */

@Data
public class OrderItem {
    private String order_id;
    private String product_id;
    private int buynum;
}
