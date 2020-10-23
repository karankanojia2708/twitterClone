package com.example.twitter.clone.twitterclone.controllers;

import com.example.twitter.clone.twitterclone.dto.FollowerDto;
import com.example.twitter.clone.twitterclone.dto.TokenDto;
import com.example.twitter.clone.twitterclone.model.Post;
import com.example.twitter.clone.twitterclone.model.User;
import com.example.twitter.clone.twitterclone.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
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
    public String createUser(@RequestParam("username") String username, @RequestParam("password") String password){
        return service.createUser(username, password);
    }
    @PostMapping("/add/follower")
    public String addFollower(@RequestParam("username") String username, @RequestBody FollowerDto dto){
        return service.addFollower(username, dto);
    }
    @GetMapping("/get/follower/list")
    public List<User> getFollowerList(@RequestParam("username") String username){
        return service.getFollowerList(username);
    }

    @GetMapping("/get/following/list")
    public List<User> getFollowingList(@RequestParam("username") String username){
        return service.getFollowingList(username);
    }

    @GetMapping("/get/post/list")
    public List<Post> getPostList(@RequestParam("username") String username){
        return service.getPostList(username);
    }

    @PostMapping("/login/hash/code")
    public String getAccessToken(@RequestBody TokenDto dto){
        return service.getAccessToken(dto);
    }

}
