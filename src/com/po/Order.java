package com.po;

import lombok.Data;

import java.util.Date;

/**
 * @Author: Fisher
 * @Date: 2019/12/14 10:44 上午
 */

@Data
public class Order {
    private String id;
    private double money;
    private String receiverinfo;
    private int paystate;
    private Date ordertime;
    private int user_id;
}
