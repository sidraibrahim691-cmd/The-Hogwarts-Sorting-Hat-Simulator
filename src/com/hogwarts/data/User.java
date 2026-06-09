package com.hogwarts.data;

public class User {
    private String user_name;
    private String user_house;

    public User(String user_name){
        this.user_name = user_name;
        user_house = "Not yet Sorted";
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setUser_house(String user_house) {
        this.user_house = user_house;
    }

    public String getUser_name(){
        return this.user_name;
    }

    public String getUser_house(){
        return this.user_house;
    }
}