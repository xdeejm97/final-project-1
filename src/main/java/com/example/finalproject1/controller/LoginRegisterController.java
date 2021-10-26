package com.example.finalproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class LoginRegisterController {
    @GetMapping(value = {"/login"})
    public String getLogin() {
        return "loginPages/login";
    }

    @GetMapping(value = {"/register"})
    public String getRegister() {
        return "loginPages/register";
    }

}


