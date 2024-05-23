package com.ping.sportplatform.mapper;

import com.ping.sportplatform.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {

    /**
     * 根據登入訊息查詢會員
     * @param username
     * @param password
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password} AND state = 1")
    User getUserByMessage(String username, String password);
}
