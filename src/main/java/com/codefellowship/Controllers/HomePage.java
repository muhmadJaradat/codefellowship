package com.codefellowship.Controllers;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class HomePage {

    @GetMapping
    public String getHomePage(Principal principal, Model model){
        if (principal!=null)model.addAttribute("userName",principal.getName());
        return "Home";
    }
}
