package com.example.twitter.clone.twitterclone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

@Data
@Table(name = "user_instance", uniqueConstraints={@UniqueConstraint(columnNames={"username"})})
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @Column(name = "username")
    private String username;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private Set<User> followers;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    private Set<User> following;

    @OneToMany(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name="post_id")
    private Set<Post> posts;

}
