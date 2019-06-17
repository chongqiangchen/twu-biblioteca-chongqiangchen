package com.twu.biblioteca;


import java.util.ArrayList;
import java.util.Scanner;

public class Enter {
    private ArrayList<User> users;
    private boolean isLogin;
    private User curUser;

    private Scanner scanner = new Scanner(System.in);

    public Enter(ArrayList<User> users){
        this.users = users;
    }

    public boolean login(){
        System.out.println("Please enter username: ");
        String username = scanner.next();
        System.out.println("Please enter password: ");
        String password = scanner.next();
        for (User user:this.users){
            if(username.equals(user.getUserName()) && password.equals(user.getPassword())){
                curUser = user;
                isLogin = true;
                System.out.println("Login Success!");
                return true;
            }
        }
        System.out.println("Login Fail! Please login again!");
        return false;
    }
    public String getUserInfo(){
        return curUser.getUserInfo();
    }
    public User getCurUser(){
        return curUser;
    }
    public boolean isLogin(){
        return isLogin;
    }
}
