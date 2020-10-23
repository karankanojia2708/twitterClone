package com.example.twitter.clone.twitterclone.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TokenDto {
    @JsonProperty("username")
    public String username;

    @JsonProperty("password")
    public String password;
}
