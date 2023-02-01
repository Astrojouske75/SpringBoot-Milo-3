package com.fundamentos.SpringBoot.fundamentos.caseUse;

import com.fundamentos.SpringBoot.fundamentos.Entity.User;
import com.fundamentos.SpringBoot.fundamentos.Service.UserService;

import java.util.List;

public class GetUserImplement implements GetUser{
    private UserService userService;

    public GetUserImplement(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return (List<User>) userService.getAllUsers();
    }
}
