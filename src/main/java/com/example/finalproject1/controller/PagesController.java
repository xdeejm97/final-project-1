package com.example.finalproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class PagesController {

    @RequestMapping(value = "/about-us", method = RequestMethod.GET)
    public String getAboutUs(){

        return "pages/about-us";
    }
    @RequestMapping(value = "/contact-us", method = RequestMethod.GET)
    public String getContactUs(){

        return "pages/contact-us";
    }
    @RequestMapping(value = "/user-profile", method = RequestMethod.GET)
    public String getUserProfile(){

        return "pages/user-profile";
    }


}
