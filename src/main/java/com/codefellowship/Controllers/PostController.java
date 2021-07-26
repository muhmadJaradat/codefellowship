package com.codefellowship.Controllers;


import com.codefellowship.Models.ApplicationUser;
import com.codefellowship.Models.Post;
import com.codefellowship.Repositories.ApplicationUserRepository;
import com.codefellowship.Repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
import java.util.Date;

@Controller
public class PostController {

    @Autowired
    private ApplicationUserRepository applicationUserRepository;
    @Autowired
    private PostRepository postRepository;

    @PostMapping("/myprofile")
    public RedirectView createPost( String postBody, Principal principal) {

        ApplicationUser user=applicationUserRepository.findApplicationUserByUsername(principal.getName());
        Post newPost = new Post(postBody,user);
        postRepository.save(newPost);
        return new RedirectView("/myprofile");
    }
}
