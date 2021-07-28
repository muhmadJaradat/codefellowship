package com.codefellowship.Controllers;

import com.codefellowship.Models.ApplicationUser;
import com.codefellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;



@Controller
public class HomePage {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping
    public String getHomePage(Principal principal, Model model){

        if (principal!=null){
            ApplicationUser loggedUser=applicationUserRepository.findApplicationUserByUsername(principal.getName());
            model.addAttribute("userName",principal.getName());
            model.addAttribute("loggedUser",loggedUser);
        }
        model.addAttribute("users",applicationUserRepository.findAll());
        return "Home";
    }

    @GetMapping("/feed")
    public String feedPage(Principal principal,Model model){
        if (principal!=null){
            ApplicationUser user=applicationUserRepository.findApplicationUserByUsername(principal.getName());
            model.addAttribute("user",user);
        }
        return "feed";
    }
}
