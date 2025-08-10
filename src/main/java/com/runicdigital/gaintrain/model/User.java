package com.runicdigital.gaintrain.model;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class User {
    private long userId;
    private String email;
    private String nickname;
    private String password;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = Base64.getEncoder().encode(password.getBytes(StandardCharsets.UTF_8)).toString();
    }
}
