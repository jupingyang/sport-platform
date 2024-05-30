package com.ping.sportplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.ping.sportplatform.bean.MainMenu;
import com.ping.sportplatform.bean.SubMenu;
import com.ping.sportplatform.mapper.MenuMapper;
import com.ping.sportplatform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;
    /**
     * 獲取導航菜單
     * @return
     */
    @Override
    public String getAllMenus() {
//        System.out.println("訪問成功");
        HashMap<String,Object> data = new HashMap<>();
        List<MainMenu> menus = menuMapper.getMenus();
        if(menus != null){
            data.put("menus",menus);
            data.put("flag",200);
        }else {
            data.put("flag",404);
        }
        String res = JSON.toJSONString(data);
        return res;
    }

    /**
     * 根據mid查詢submenu
     * @param id
     * @return
     */
    @Override
    public SubMenu getSubMenuByMid(int id) {
        SubMenu subMenuByMid = menuMapper.getSubMenuByMid(id);
        return subMenuByMid;
    }
}
