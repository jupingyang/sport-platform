package com.ping.sportplatform.service;

import com.ping.sportplatform.bean.QueryInfo;
import com.ping.sportplatform.bean.User;

import java.util.List;

public interface UserService {

    /**
     * 會員登入
     * @param user
     * @return
     */
    String login(User user);

    /**
     * 獲取用戶列表
     * @param queryInfo
     * @return
     */
    String getUserList(QueryInfo queryInfo);

    /**
     * 用戶狀態更新
     * @param id
     * @param state
     * @return
     */
    String updateUserState(Integer id, Boolean state);

    /**
     * 新增用戶
     * @param user
     * @return
     */
    String addUser(User user);

    /**
     * 刪除用戶
     * @param id
     * @return
     */
    String deleteUser(int id);




}
