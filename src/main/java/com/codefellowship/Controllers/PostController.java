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

    @PostMapping("/users/post")
    public RedirectView createPost( String postBody, Principal p) {

        Post newPost = new Post(postBody, new Date());
        ApplicationUser user = (ApplicationUser) ((UsernamePasswordAuthenticationToken) p).getPrincipal();
        newPost.user = applicationUserRepository.findApplicationUserByUsername(user.getUsername());
        postRepository.save(newPost);
        return new RedirectView("/}");
    }
}
