package com.example.twitter.clone.twitterclone.repository;

import com.example.twitter.clone.twitterclone.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {
}
