package com.example.finalproject1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoriesController {

    @RequestMapping(value ="/automotive" , method = RequestMethod.GET)
    public String getAutomotivePage(){

        return "categories/automotive";
    }
    @RequestMapping(value ="/electronics" , method = RequestMethod.GET)
    public String getElectronicsPage(){
        return "categories/electronics";
    }
    @RequestMapping(value ="/fashion" , method = RequestMethod.GET)
    public String getFashionPage(){
        return "categories/fashion";
    }
    @RequestMapping(value ="/realEstate" , method = RequestMethod.GET)
    public String getRealEstatePage(){
        return "categories/realEstate";
    }


}
