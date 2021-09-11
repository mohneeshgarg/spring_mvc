package com.group4.twitter.Controllers;

import com.group4.twitter.Entities.Message;
import com.group4.twitter.Services.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class MessageController {
    @Autowired
    MessageService messageService;

    @GetMapping("/test")
    public String test(){
        return "Its working.";
    }

    @GetMapping("/user/{id}/message/sent")
    public List<Message> getSentMessages(@PathVariable("id") int senderId){
        List<Message> sentList = messageService.findSentMessages(senderId);
        System.out.println(sentList);
        return sentList;
    }

    @GetMapping("/user/{id}/message/received")
    public List<Message> getReceivedMessages(@PathVariable("id") int receiverId){
        List<Message> receivedList =  messageService.findReceivedMessages(receiverId);
        System.out.println(receivedList);
        return receivedList;
    }

    @PostMapping("/message/new")
    public String newMessage(@RequestBody Message message){
        Date current_date = new Date();
        message.setDate(current_date);
        message.setTime(current_date);
        messageService.insert(message);
        return "Message Created";
    }
}
