package com.runicdigital.gaintrain.controller;

import com.runicdigital.gaintrain.model.User;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class UserController {
    private final String TEMP_PWD = "temp123";
    public User createUser(String nickname, String email) {
        User user = new User();
        if (validNickname(nickname)) user.setNickname(nickname);
        else throw new RuntimeException("Invalid nickname");
        if (validEmail(email)) user.setEmail(email);
        else throw new RuntimeException("Invalid email");
        user.setPassword(Base64.getEncoder().encode(TEMP_PWD.getBytes(StandardCharsets.UTF_8)).toString());
        return user;
    }

    private boolean validNickname(String nickname) {
        return (!nickname.isEmpty());
    }

    private boolean validEmail(String email) {
        return email.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$");
    }
}
