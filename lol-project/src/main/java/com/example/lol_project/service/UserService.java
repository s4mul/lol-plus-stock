package com.example.lol_project.service;

import com.example.lol_project.domain.User;
import com.example.lol_project.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class UserService {

    private final UserMapper userMapper;

    public UserService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    // 회원가입

    public void register(User user){

        userMapper.insertUser(user);
    }

    //로그인 검증 (비밀번호 비교)
    public boolean authenticate(String userId, String password){
        User user = userMapper.findByUserId(userId);

        if(user==null){
            return false;
        }

        if(!user.getPassword().equals(password)){
            return false;
        }

        return true;
    }


    private String hashPassword(String password) {
        try{
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] hashedBytes = md.digest(password.getBytes(StandardCharsets.UTF_8));
            StringBuilder sb = new StringBuilder();
            for(byte b : hashedBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch(NoSuchAlgorithmException e) {
            throw new RuntimeException("비밀번호 해싱 실패", e);
        }
    }




}
