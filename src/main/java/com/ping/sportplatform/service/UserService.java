package com.ping.sportplatform.service;

import com.ping.sportplatform.bean.User;

public interface UserService {

    /**
     * 會員登入
     * @param user
     * @return
     */
    String login(User user);
}
