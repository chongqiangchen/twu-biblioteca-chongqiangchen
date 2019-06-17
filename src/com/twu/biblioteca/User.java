package com.twu.biblioteca;

public class User {
    private String username;
    private String password;
    private String email;
    private String phone;

    public User(String username,String password,String email,String phone){
        this.username = username;
        this.password = password;
        this.email = email;
        this.phone = phone;
    }

    public String getUserName(){
        return this.username;
    }
    public String getEmail(){
        return this.email;
    }
    public String getPhone(){
        return this.phone;
    }
    public String getPassword(){
        return this.password;
    }
    public String getUserInfo(){
        String formatUserInfo = this.username + ", " + this.email +", " + this.phone;
        return formatUserInfo;
    }


}
