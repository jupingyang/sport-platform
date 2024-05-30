package com.ping.sportplatform.service;

import com.ping.sportplatform.bean.MainMenu;
import com.ping.sportplatform.bean.SubMenu;

import java.util.List;

public interface MenuService {

    /**
     * 獲取導航菜單
     * @return
     */
    public String getAllMenus();

    /**
     * 根據mid查詢submenu
     * @param id
     * @return
     */
    public SubMenu getSubMenuByMid(int id);
}
