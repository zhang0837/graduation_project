package com.example.demo.controller;

import com.example.demo.bean.UserBean;
import com.example.demo.mapper.UserMapper;
import com.example.demo.service.CheckUserInfo;
import com.example.demo.service.CheckUserInfoIm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import sun.text.normalizer.NormalizerBase;

import java.util.Map;

@Controller
public class HelloController {
    @Autowired
    CheckUserInfoIm checkUserInfoIm;

    @RequestMapping(value = "/")
    public String homePage() {
        return "login";
    }
    @RequestMapping("checkUserInfo")
    public String checkUserinfo(Model model,String userName, String password) {
        UserBean user = checkUserInfoIm.checkUserInfo(userName,password);
        if(user==null){
            model.addAttribute("message","你还没注册，请先注册后登录");
            return "error";
        }else {
            model.addAttribute("message", "登录成功");
            return "success";
        }
    }
}
