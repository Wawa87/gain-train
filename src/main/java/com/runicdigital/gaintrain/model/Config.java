package com.runicdigital.gaintrain.model;

public class Config {
    private Long id;
    private Long userId;
    private String ckey;
    private String cval;

    public Config() {}

    public Config(Long id, Long user_id, String ckey, String cval){
        this.id = id;
        this.userId = user_id;
        this.ckey = ckey;
        this.cval = cval;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getCkey() {
        return ckey;
    }

    public void setCkey(String ckey) {
        this.ckey = ckey;
    }

    public String getCval() {
        return cval;
    }

    public void setCval(String cval) {
        this.cval = cval;
    }
}
