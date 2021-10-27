package com.example.finalproject1.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommentaryController {

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
