package com.ping.sportplatform.controller;

import com.ping.sportplatform.bean.MainMenu;
import com.ping.sportplatform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @RequestMapping("/menus")
    public String getAllMenus(){
        String res = menuService.getAllMenus();
        return res;
    }
}
