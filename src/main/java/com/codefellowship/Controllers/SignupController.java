package com.codefellowship.Controllers;

import com.codefellowship.Models.ApplicationUser;
import com.codefellowship.Repositories.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.view.RedirectView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class SignupController {

    @Autowired
    ApplicationUserRepository applicationUserRepository;

    @Autowired
    BCryptPasswordEncoder encoder;

    @GetMapping("/signup")
    public String getSignupPage() {
        return "signup";
    }

    @InitBinder
    public void initBinder(WebDataBinder binder, WebRequest request) {
        //convert the date Note that the conversion here should always be in the same format as the string passed in, e.g. 2015-9-9 should be yyyy-MM-dd
        DateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));// CustomDateEditor is a custom date editor
    }

    @PostMapping("/signup")
    public RedirectView signupForm(String userName, String password, String firstName, String lastName, Date dtb,String bio){
        ApplicationUser user =new ApplicationUser(userName, encoder.encode(password) ,firstName,lastName,dtb,bio);
        applicationUserRepository.save(user);
        Long id=user.getId();
        return new RedirectView("/");
    }

}
