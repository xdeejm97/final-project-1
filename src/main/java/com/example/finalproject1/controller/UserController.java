package com.example.finalproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    @GetMapping(value = {"/user"})
    public String getLogin() {
        return "user";
    }

    @GetMapping(value = {"/editUser"})
    public String editUser() {
        return "editUser";
    }

    @GetMapping(value = {"/deleteUser"})
    public String deleteUser() {
        return "deleteUser";
    }

    @RequestMapping(value = {"/addComment"})
    public String addComment() {
        return "addComment";
    }


    @RequestMapping(value = {"/deleteComment"})
    public String deleteComment() {
        return "deleteComment";
    }

    @RequestMapping(value = {"/editComment"})
    public String editComment() {
        return "editComment";
    }
}

