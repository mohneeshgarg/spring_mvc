package com.group4.twitter.Controllers;

import com.group4.twitter.Entities.Tweet;
import com.group4.twitter.Entities.User;
import com.group4.twitter.Services.UserService;
import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    UserService userService;
    RestTemplate restTemplate = new RestTemplate();
    String tweet_url = "http://localhost:8083/";
    @RequestMapping("/admin")
    public ModelAndView openAdmin(){
        ModelAndView mv = new ModelAndView("admin");
        return mv;
    }
    @RequestMapping("/admin/tweets")
    public ModelAndView allTweets(){
        ModelAndView mv = new ModelAndView("tweets");
        List<Tweet> tweets = restTemplate.getForObject(tweet_url+"tweets/all", List.class);
        mv.addObject("tweets", tweets);
        return mv;
    }
    @RequestMapping("/admin/users")
    public ModelAndView allUsers(){
        ModelAndView mv = new ModelAndView("users");
        List<User> users = userService.findAllUsers();
        mv.addObject("users", users);
        return mv;
    }
    @RequestMapping("/admin/tweet/delete/{id}")
    public String deleteTweet(@PathVariable int id){
        String s = restTemplate.postForObject(tweet_url+"tweet/delete", id, String.class);
        return "redirect:/admin";
    }
    @RequestMapping("/admin/user/delete/{id}")
    public String deleteUser(@PathVariable int id){
        String s = userService.deleteUser(id);
        return "redirect:/admin";
    }
}
