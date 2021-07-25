package com.codefellowship.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomePage {

    @GetMapping
    public String getHomePage(){
        return "Home";
    }
}
