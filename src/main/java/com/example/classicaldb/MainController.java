package com.example.classicaldb;

import org.springframework.web.bind.annotation.GetMapping;

public class MainController {

    @GetMapping("")
    public String showHomePage(){
        return "index";
    }
}
