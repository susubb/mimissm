package com.shuq.service;

import com.shuq.pojo.Admin;

public interface AdminService {
    //完成登录判断
    Admin login(String name, String pwd);
}
