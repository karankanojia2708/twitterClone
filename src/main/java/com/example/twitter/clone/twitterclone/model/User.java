package com.example.twitter.clone.twitterclone.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.*;

@Data
@Table(name = "user_instance")
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;

   @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private List<User> followers;

    @JsonIgnore
    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private List<User> following;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name="post_id")
    @JsonIgnore
    private List<Post> posts;

}
