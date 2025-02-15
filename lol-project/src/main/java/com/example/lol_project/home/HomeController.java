package com.example.lol_project.controller;

import com.example.lol_project.domain.LoginRequest;
import com.example.lol_project.domain.User;
import com.example.lol_project.service.UserService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
public class HomeController {

    private UserService userService;

    public HomeController(UserService userService) {
        this.userService = userService;
    }

    //회원가입 API
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user){
        userService.register(user);
        return ResponseEntity.ok("회원가입 성공");
    }

    //로그인 API
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequest loginRequest){
        boolean isAuthenticated = userService.authenticate(loginRequest.getUserId(), loginRequest.getPassword());

        if(isAuthenticated){
            return ResponseEntity.ok("로그인 성공");
        }
        else{
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("로그인 실패");
        }
    }




}