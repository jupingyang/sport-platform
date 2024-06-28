package com.ping.sportplatform.service.impl;

import com.alibaba.fastjson.JSON;
import com.ping.sportplatform.bean.QueryInfo;
import com.ping.sportplatform.bean.User;
import com.ping.sportplatform.mapper.UserMapper;
import com.ping.sportplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

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
            flag = "success";
        }
        data.put("flag",flag);
        data.put("user",user);

        String res = JSON.toJSONString(data);
        return res;
    }

    /**
     * 獲取用戶列表
     * @param queryInfo
     * @return
     */
    public String getUserList(QueryInfo queryInfo){
        // 獲取最大列表數
        int numbers = userMapper.getUserCounts("%" + queryInfo.getQuery() + "%");
        int pageStart = (queryInfo.getPageNum()-1) * queryInfo.getPageSize();

        List<User> users = userMapper.getAllUser("%" + queryInfo.getQuery() + "%",pageStart,queryInfo.getPageSize());
        HashMap<String, Object> res = new HashMap<>();
        res.put("numbers",numbers);
        res.put("data",users);
        String res_json = JSON.toJSONString(res);
        return res_json;
    }

    /**
     * 用戶狀態更新
     * @param id
     * @param state
     * @return
     */
    @Override
    public String updateUserState(Integer id, Boolean state) {
        int i = userMapper.updateState(id, state);
//        System.out.println(i);
        return i > 0 ? "success" : "error";
    }

    /**
     * 新增用戶
     * @param user
     * @return
     */
    @Override
    public String addUser(User user) {
        user.setRole("普通用戶");
        user.setState(false);
        int i = userMapper.addUser(user);
        return i > 0 ? "success" : "error";
    }

    /**
     * 刪除用戶
     * @param id
     * @return
     */
    @Override
    public String deleteUser(int id) {
        int i = userMapper.deleteUser(id);
        return i > 0 ? "success" : "error";
    }

    /**
     * 根據id查詢用戶資料
     * @param id
     * @return
     */
    @Override
    public String getUserById(int id) {
        User user = userMapper.getUserById(id);
        String res = JSON.toJSONString(user);
        return res;
    }

    /**
     * 更新用戶資料
     * @param user
     * @return
     */
    @Override
    public String updateUser(User user) {
        int i = userMapper.updateUser(user);
        return i > 0? "success":"error";
    }
}
