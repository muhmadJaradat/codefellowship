package com.codefellowship.Controllers;

import com.codefellowship.Models.ApplicationUser;
import com.codefellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.security.Principal;
import java.util.Optional;

@Controller
public class ProfileController {
    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @GetMapping("/users/{id}")
    public String getProfilePage(Model model, @PathVariable Long id){
        Optional<ApplicationUser> user=applicationUserRepository.findById(id);

        model.addAttribute("user", user.get());
        return "profile";

         }

    @GetMapping(value="/myprofile")
    public String showProfile(Principal principal, Model m) {
        if(principal != null) {

            ApplicationUser user = applicationUserRepository.findApplicationUserByUsername(principal.getName());
            m.addAttribute("user",user);
            m.addAttribute("userName",principal.getName());
        }

        return "profile";
    }
}
