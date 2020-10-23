package com.example.twitter.clone.twitterclone.services;


import com.example.twitter.clone.twitterclone.dto.FollowerDto;
import com.example.twitter.clone.twitterclone.dto.TokenDto;
import com.example.twitter.clone.twitterclone.model.Post;
import com.example.twitter.clone.twitterclone.model.User;
import com.example.twitter.clone.twitterclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public User getUserViaUsername(String username){
        Optional<User> user = this.repository.findUserByUsername(username);
        if(user.isPresent()){
            return user.get();
        }else{
            return null;
        }
    }

    public String createUser(String username, String password){
        try{
            Optional<User> p = this.repository.findUserByUsername(username);
            if(p.isPresent()){
                return "User already present";
            }else{
                User user = new User();
                user.setUsername(username);
                user.setPassword(password);
                user.setFollowing(new ArrayList<>());
                user.setPosts(new ArrayList<>());
                repository.save(user);
                return "User created";
            }

        }catch(Exception e){
            return e.toString();
        }
    }

    public String addFollower(String username, FollowerDto dto){
        try {
            Optional<User> user = repository.findUserByUsername(dto.username);
            if(user.isPresent()){
                Optional<User> user1 = repository.findUserByUsername(username);
                if(user1.isPresent()){
                    if (user1.get().getFollowing().contains(user.get())){
                        return "Already following";
                    }else{
                        user1.get().getFollowing().add(user.get());
                        user.get().getFollowers().add(user1.get());
                        this.repository.save(user.get());
                        this.repository.save(user1.get());
                        return user1.get().getUsername()+" is following "+ user.get().getUsername();
                    }
                }else{
                    return "User not found";
                }
            }else{
                return "User not found";
            }
        }catch (Exception e){
            return e.toString();
        }
    }

    public List<User> getFollowingList(String username){
        Optional<User> user =  this.repository.findUserByUsername(username);
        if(user.isPresent()) {
            return user.get().getFollowing();
        }else{
            return null;
        }
    }

    public List<User> getFollowerList(String username){
        Optional<User> user =  this.repository.findUserByUsername(username);
        if(user.isPresent()) {
            return user.get().getFollowers();
        }else{
            return null;
        }
    }

    public List<Post> getPostList(String username){
        Optional<User> user =  this.repository.findUserByUsername(username);
        if(user.isPresent()) {
            return user.get().getPosts();
        }else{
            return null;
        }
    }

    public String getAccessToken(TokenDto dto){
        String username = dto.username;
        String password = dto.password;
        Optional<User> user = this.repository.findUserByUsername(username);
        if(user.isPresent()){
            if(user.get().getPassword().equals(password)){
                return "A random hashcode which can be later used to authenticate by inserting it in all requests";
            }else{
                return "Invalid password";
            }
        }else{
            return "Invalid username";
        }
    }

}
