package ua.proxyband.twitter.dto;

import lombok.Data;

import java.util.List;


@Data
public class UserWithPostsDTO {
    String userId;
    List<PostWithDetails> posts;
}