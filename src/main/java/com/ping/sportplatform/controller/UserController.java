package com.ping.sportplatform.controller;

import com.ping.sportplatform.bean.QueryInfo;
import com.ping.sportplatform.bean.User;
import com.ping.sportplatform.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 獲取用戶列表
     * @param queryInfo
     * @return
     */
    @RequestMapping("/allUser")
    public String getUserList(QueryInfo queryInfo){
//        System.out.println(queryInfo);
        String res = userService.getUserList(queryInfo);
        return res;
    }

    /**
     * 用戶狀態更新
     * @param id
     * @param state
     * @return
     */
    @RequestMapping("/userState")
    public String updateUserState(@RequestParam("id") Integer id, @RequestParam("state") Boolean state){
//        System.out.println("用戶id:"+id);
//        System.out.println("用戶狀態:"+state);
        String res = userService.updateUserState(id, state);
        return res;
    }

    /**
     * 新增用戶
     * @param user
     * @return
     */
    @RequestMapping("/addUser")
    public String addUser(@RequestBody User user){
        String res = userService.addUser(user);
        return res;
    }

    /**
     * 刪除用戶
     * @return
     */
    @RequestMapping("/deleteUser")
    public String deleteUser(int id){
        String res = userService.deleteUser(id);
        return res;
    }

    /**
     * 根據id查詢用戶資料
     * @param id
     * @return
     */
    @RequestMapping("/getUser")
    public String getUserById(int id){
        String res = userService.getUserById(id);
        return res;
    }

    /**
     * 更新用戶資料
     * @param user
     * @return
     */
    @RequestMapping("/updateUser")
    public String updateUser(@RequestBody User user){
        String res = userService.updateUser(user);
        return res;
    }
}
