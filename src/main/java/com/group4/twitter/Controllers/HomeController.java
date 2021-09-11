package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.Tweet;
import com.group4.twitter.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    UserDAO userDAO;

    RestTemplate restTemplate = new RestTemplate();

    @RequestMapping("/")
    public ModelAndView openHome(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mv = new ModelAndView("home");
        boolean flag = false;

        if (!(auth instanceof AnonymousAuthenticationToken)) {
            flag = true;
            String username = ((UserDetails)auth.getPrincipal()).getUsername();
            User user = userDAO.findByUserName(username);
            mv.addObject("id", user.getId());
        }
        String url = "http://localhost:8083/";
        List<Tweet> tweetList = restTemplate.getForObject(url+"tweets/all", List.class);
        mv.addObject("flag",  flag);
        System.out.println(tweetList);
        mv.addObject("tweets", tweetList);
        return mv;
    }
    @RequestMapping("/register")
    public String register(){
        return "register";
    }
}
