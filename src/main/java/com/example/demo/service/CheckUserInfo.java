package com.example.demo.service;

import com.example.demo.bean.UserBean;

public interface CheckUserInfo {
    public UserBean checkUserInfo(String userName,String password);

    public UserBean ajaxCheckUserName(String txtName);
}
