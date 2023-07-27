package ua.proxyband.twitter.dto;

import lombok.Data;
import ua.proxyband.twitter.model.Comment;
import ua.proxyband.twitter.model.Like;
import ua.proxyband.twitter.model.Post;

import java.util.List;

@Data
public
class PostWithDetails {
    Post post;
    List<Like> likes;
    List<Comment> comments;
}
