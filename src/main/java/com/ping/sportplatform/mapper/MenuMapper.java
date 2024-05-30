package com.ping.sportplatform.mapper;

import com.ping.sportplatform.bean.MainMenu;
import com.ping.sportplatform.bean.SubMenu;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.mapping.FetchType;

import java.util.List;

public interface MenuMapper {

    /**
     * 獲取導航菜單
     * @return
     */
//    @Select("SELECT mm.*, sm.id AS sid, sm.title AS stitle, sm.path AS spath FROM mainmenu mm, submenu sm WHERE mm.id = sm.mid")
    @Select("SELECT * FROM mainmenu")
    @Results(id = "mainMenuMap", value = {
            @Result(id = true,column = "id",property = "id"),
            @Result(column = "title",property = "title"),
            @Result(column = "path",property = "path"),
            @Result(property = "subMenuList",column = "id",many = @Many(select = "com.ping.sportplatform.mapper.MenuMapper.getSubMenuByMid",fetchType = FetchType.LAZY))
    })
    List<MainMenu> getMenus();

    /**
     * 根據mid查詢submenu
     * @param id
     * @return
     */
    @Select("SELECT * FROM submenu where mid = #{id}")
    SubMenu getSubMenuByMid(int id);
}
