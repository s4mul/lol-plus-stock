package com.example.lol_project.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User {


    private Long id;
    private String userId;
    private String password;


    public User(){

    }

    public User(String userId, String password){
        this.userId = userId;
        this.password = password;
    }


}
