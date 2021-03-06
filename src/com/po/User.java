package com.po;

import lombok.Data;

/**
 * @Author: Fisher
 * @Date: 2019/12/4 10:04 上午
 */

@Data
public class User {
    private Integer id;
    private String username;
    private String password;
    private String password2;
    private String nickname;
    private String email;

    @Override
    public String toString() {
        return username + "--" + password;
    }
}
