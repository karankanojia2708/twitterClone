package com.example.twitter.clone.twitterclone.services;


import com.example.twitter.clone.twitterclone.model.User;
import com.example.twitter.clone.twitterclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

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

    public boolean createUser(String username){
        try{
            User user = new User();
            user.setUsername(username);
            user.setFollowers(new HashSet<>());
            user.setFollowing(new HashSet<>());
            user.setPosts(new HashSet<>());
            repository.save(user);
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
