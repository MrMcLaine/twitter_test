package ua.proxyband.twitter.service;

import ua.proxyband.twitter.model.Comment;

import java.util.List;

public interface CommentService {
    Comment createComment(Comment comment);
    List<Comment> getCommentsByPostId(String postId);
}
