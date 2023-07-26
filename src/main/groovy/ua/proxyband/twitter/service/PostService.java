package ua.proxyband.twitter.service;

import ua.proxyband.twitter.model.Post;

public interface PostService {
    Post createPost(Post post);
    Post updatePost(String postId, Post post);
    boolean deletePost(String postId);
}
