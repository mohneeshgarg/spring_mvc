package com.group4.twitter.Controllers;

import com.group4.twitter.DAO.UserDAO;
import com.group4.twitter.Entities.Tweet;
import com.group4.twitter.Entities.User;
import com.group4.twitter.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserService userService;
    @Autowired
    UserDAO userDAO;

    RestTemplate restTemplate = new RestTemplate();
    @RequestMapping("/user")
    public ModelAndView profilePage(){
        ModelAndView mv = new ModelAndView("user");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        String url = "http://localhost:8083/";
        User user = userDAO.findByUserName(username);
        List<Tweet> tweets = restTemplate.getForObject(url+"user/"+user.getId()+"/tweets", List.class);

        System.out.println(tweets);
        mv.addObject("tweets", tweets);
        mv.addObject("user", user);
        return mv;
    }
    @GetMapping("/user/addUser")
    public String addUser(@RequestParam("userName") String userName,
                          @RequestParam("name") String name,
                          @RequestParam("age") int age,
                          @RequestParam("password") String password){
        User user = new User(name, age, userName, password);
        System.out.println(user);
        userService.addUser(user);
        return "redirect:/login";
    }
    @RequestMapping("/user/update/name")
    public String updateName(@RequestParam("name") String name){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        User user = userDAO.findByUserName(username);
        user.setName(name);
        userService.updateUser(user);
        return "redirect:/user";
    }
    @RequestMapping("/user/update/age")
    public String updateAge(@RequestParam("age") int age){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = ((UserDetails)auth.getPrincipal()).getUsername();
        User user = userDAO.findByUserName(username);
        user.setAge(age);
        userService.updateUser(user);
        return "redirect:/user";
    }
    @RequestMapping("/user/all")
    public List<User> showAll(){
        return userService.findAllUsers();
    }
    @RequestMapping("/user/find")
    public User findUser(@RequestParam("id") int id){
        return userService.findUser(id);
    }
}
