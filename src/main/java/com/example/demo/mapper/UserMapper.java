package com.example.demo.mapper;


import com.example.demo.bean.UserBean;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
   public UserBean CheckUserInfo(String userName, String password);
}
