package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.service.CheckUserInfoIm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {
    @Autowired
    CheckUserInfoIm checkUserInfoIm;

    @RequestMapping(value = "/")
    public String homePage() {
        return "login";
    }

    @RequestMapping(value = "registerPage")
    public String registerPage() {
        return "regist";
    }

    @ResponseBody
    @RequestMapping("checkUserInfo")
    public boolean checkUserinfo(String txtName, String txtPass) {
        UserBean user = checkUserInfoIm.checkUserInfo(txtName, txtPass);
        if (user == null) {
            return false;
        } else {
             return true;
        }
    }
    @ResponseBody
    @RequestMapping("ajaxCheckUserName")
    public boolean ajaxCheckUserName(String txtName) {
        UserBean user = checkUserInfoIm.ajaxCheckUserName(txtName);
        if (user == null) {
            return false;
        } else {
            return true;
        }
    }
}