package com.example.twitter.clone.twitterclone.services;

import com.example.twitter.clone.twitterclone.dto.PostDto;
import com.example.twitter.clone.twitterclone.model.Post;
import com.example.twitter.clone.twitterclone.model.User;
import com.example.twitter.clone.twitterclone.repository.PostRepository;
import com.example.twitter.clone.twitterclone.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository postRepository;
    @Autowired
    private UserRepository userRepository;
    public String addPost(String username, PostDto dto){
        Optional<User> user = userRepository.findUserByUsername(username);
        if(user.isPresent()){
            if(dto.content.split(" ").length > 140){
                return "Content to large";
            }else{
                Post post = new Post();
                post.setContent(dto.content);
                post.setUser(user.get());
                user.get().getPosts().add(post);
                postRepository.save(post);
                userRepository.save(user.get());
                return "Post added successfully";
            }
        }else{
            return "Invalid username";
        }
    }

}
