package com.example.demo.service;

import com.example.demo.bean.UserBean;
import com.example.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CheckUserInfoIm implements CheckUserInfo {
    @Autowired(required=false)
    UserMapper userMapper;
    @Override
    public UserBean checkUserInfo(String userName,String password) {
        UserBean user = userMapper.CheckUserInfo(userName, password);
        return user;
    }

    @Override
    public UserBean ajaxCheckUserName(String txtName) {
        UserBean user = userMapper.ajaxCheckUserName(txtName);
        return user;
    }
}
