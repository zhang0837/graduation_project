package cn.zhang.cn.mapper;

import cn.zhang.cn.bean.UserBean;

public interface UserMapper {
    UserBean getInfo(String name,String password);
}
