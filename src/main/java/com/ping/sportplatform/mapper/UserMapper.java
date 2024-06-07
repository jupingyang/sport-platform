package com.ping.sportplatform.mapper;

import com.ping.sportplatform.bean.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    /**
     * 根據登入訊息查詢會員
     * @param username
     * @param password
     * @return
     */
    @Select("SELECT * FROM user WHERE username = #{username} AND password = #{password} AND state = 1")
    User getUserByMessage(String username, String password);

    /**
     * 依查詢訊息獲取用戶列表
     * @param username
     * @param pageStart
     * @param pageSize
     * @return
     */
    List<User> getAllUser(String username, int pageStart, int pageSize);

    /**
     * 獲取用戶數
     * @param username
     * @return
     */
    int getUserCounts(String username);

    /**
     * 用戶狀態更新
     * @param id
     * @param state
     * @return
     */
    @Update("UPDATE `user` SET state = #{state} WHERE id = #{id}")
    int updateState(Integer id, Boolean state);

    /**
     * 新增用戶
     * @param user
     * @return
     */
    @Insert("INSERT INTO `user` (username,password,email,role,state)" +
            "VALUE (#{username},#{password},#{email},#{role},#{state}) ")
    int addUser(User user);

    /**
     * 刪除用戶
     * @param id
     * @return
     */
    @Delete("DELETE FROM `user` WHERE id = #{id}")
    int deleteUser(int id);
}
