package com.example.Tweet.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.Tweet.entity.Tweet;
import com.example.Tweet.service.TweetService;

@RestController
public class TweetController {
	
	   @Autowired
	    TweetService tweetService;
	    
	    @GetMapping("/home1")
	    public String test(){
	        return "Its working.";
	    }

	    @GetMapping("/user/{id}/tweets")
	    public List<Tweet> tweetsByUser(@PathVariable int id){
	        return tweetService.findByOwner(id);
	    }

	    @GetMapping("/tweets/all")
	    public List<Tweet> allTweets(){
	        return tweetService.getAllTweets();
	    }

	    @PostMapping("/tweet/add")
	    public String addTweet(@RequestBody Tweet tweet){
	    	Date timestamp = new Date();
	    	tweet.setDate(timestamp);
	    	tweet.setTime(timestamp);
	        return tweetService.insert(tweet);
	    }

	    @PostMapping("/tweet/delete")
	    public String deleteTweet(@RequestBody int id){
	        return tweetService.delete(id);}

}
