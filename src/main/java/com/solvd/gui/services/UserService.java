package com.solvd.gui.services;

import com.solvd.gui.pojo.User;

public class UserService {

    public static User getDefaultUser() {
        return new User("email123456@gmail.com","Password1234");
    }
}
