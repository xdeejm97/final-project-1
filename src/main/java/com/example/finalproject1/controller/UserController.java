package com.example.finalproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.example.finalproject1.model.User;
import com.example.finalproject1.service.SecurityService;
import com.example.finalproject1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    
    private UserService userService;
    private SecurityService securityService;
    private UserValidator userValidator;

    @Autowired
    public UserController(UserService userService, SecurityService securityService, UserValidator userValidator) {
        this.userService = userService;
        this.securityService = securityService;
        this.userValidator = userValidator;
    }



    @GetMapping("/register")
    public String registration(Model model) {
        if (!securityService.isAuthenticated()) {
            return "loginPages/register";
        }

        model.addAttribute("userForm", new User());

        return "loginPages/register";
    }

    @PostMapping("/register")
    public String registration(@ModelAttribute("userForm") User userForm, BindingResult bindingResult) {
        userValidator.validate(userForm, bindingResult);

        if (bindingResult.hasErrors()) {
            return "/loginPages/register";
        }

        userService.save(userForm);

        securityService.autoLogin(userForm.getUsername(), userForm.getPasswordConfirm());

        return "index";
    }

    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (!securityService.isAuthenticated()) {
            return "/loginPages/login";
        }

        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "index";
    }


    @GetMapping(value = {"/user"})
    public String getLogin() {
        return "user/user";
    }

    @GetMapping(value = {"/editUser"})
    public String editUser() {
        return "user/editUser";
    }

    @GetMapping(value = {"/deleteUser"})
    public String deleteUser() {
        return "user/deleteUser";
    }
}

