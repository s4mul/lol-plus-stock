package com.example.lol_project.domain;

import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class LoginRequest {

    private String userId;

    private String password;


}
