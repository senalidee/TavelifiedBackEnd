package com.cyntex.TourismApp.Beans;

public class FBTokenBean {
    private String token;
    private Long expires;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getExpires() {
        return expires;
    }

    public void setExpires(Long expires) {
        this.expires = expires;
    }

    @Override
    public String toString() {
        return super.toString() + "Token :"+token+" Expires :"+expires;
    }
}
