package com.ping.sportplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.ping.sportplatform.bean.User;
import com.ping.sportplatform.mapper.UserMapper;
import com.ping.sportplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    /**
     * 會員登入
     * @param user
     * @return
     */
    public String login(User user) {

        String flag = "error";

        String username = user.getUsername();
        String password = user.getPassword();

        User us = userMapper.getUserByMessage(username, password);
        HashMap<String, Object> data = new HashMap<>();
        if(us != null){
            flag = "ok";
        }
        data.put("flag",flag);
        data.put("user",user);

        String res = JSON.toJSONString(data);
        return res;
    }
}
