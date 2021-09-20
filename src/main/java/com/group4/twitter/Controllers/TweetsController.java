package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.Tweet;
import com.group4.twitter.Entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;

@Controller
public class TweetsController {


    @Autowired
    UserDAO userDAO;

    RestTemplate restTemplate = new RestTemplate();
    String url = "http://localhost:8083/";
    @RequestMapping("/tweet/new")
    public ModelAndView newTweet(){
        return new ModelAndView("newTweet");
    }

    @GetMapping("/tweet/save")
    public String saveTweet(@RequestParam(name = "tweet") String body){
        Date timeStamp = new Date();
        Tweet tweet = new Tweet();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        User user = userDAO.findByUserName(username);
        tweet.setOwnerID(user.getId());
        tweet.setOwnerName(user.getName());
        tweet.setBody(body);
        tweet.setDate(timeStamp);
        tweet.setTime(timeStamp);
        String s = restTemplate.postForObject(url+"/tweet/add", tweet, String.class);
        System.out.println(s);
        return "redirect:/";
    }
    @GetMapping("/tweet/delete/{id}")
    public String deleteTweet(@PathVariable int id){
        String s = restTemplate.postForObject(url+"/tweet/delete", id, String.class);
        return "redirect:/";
    }
    @GetMapping("/tweet/like/{id}")
    public String likeTweet(@PathVariable int id){
        String s = restTemplate.getForObject(url+"tweet/like/"+id, String.class);
        return "redirect:/";
    }
}