package com.example.twitter.clone.twitterclone.controllers;

import com.example.twitter.clone.twitterclone.model.User;
import com.example.twitter.clone.twitterclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @GetMapping("/test")
    public String test(){
        return "this is controller is up" ;
    }

    @Autowired
    private UserService service;

    @GetMapping("/username")
    public User getUserViaUsername(@RequestParam("username") String username){
        return service.getUserViaUsername(username);
    }
    @PostMapping("/username")
    public boolean createUser(@RequestParam("username") String username){
        return service.createUser(username);
    }
}
