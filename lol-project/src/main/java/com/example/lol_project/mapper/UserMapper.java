package com.example.lol_project.mapper;

import com.example.lol_project.domain.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Select("SELECT * FROM users WHERE userId = #{userId}")
    User findByUserId(@Param("userId") String userId);

    @Insert("INSERT INTO users (userId, password) VALUES (#{userId}, #{password})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void insertUser(User user);




}
