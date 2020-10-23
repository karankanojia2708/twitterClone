package com.example.twitter.clone.twitterclone.controllers;

import com.example.twitter.clone.twitterclone.dto.FollowerDto;
import com.example.twitter.clone.twitterclone.dto.PostDto;
import com.example.twitter.clone.twitterclone.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {
    //    @GetMapping("/test")
//    public String test(){
//        return "this is controller is up" ;
//    }


    @Autowired
    private PostService service;

    @PostMapping("/add/post")
    public String addPost(@RequestParam("username") String username, @RequestBody PostDto dto){
        return service.addPost(username, dto);
    }
}
