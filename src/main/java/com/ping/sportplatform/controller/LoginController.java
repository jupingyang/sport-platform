package com.ping.sportplatform.controller;

import com.alibaba.fastjson.JSON;
import com.ping.sportplatform.bean.User;
import com.ping.sportplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestBody User user){

        String res = userService.login(user);
        return res;
    }
}
