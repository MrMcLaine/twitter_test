package ua.proxyband.twitter.service.impl;

import org.springframework.stereotype.Service;
import ua.proxyband.twitter.model.Comment;
import ua.proxyband.twitter.repository.CommentRepository;
import ua.proxyband.twitter.service.CommentService;

import java.util.List;

@Service
class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public Comment createComment(Comment comment) {

        return commentRepository.save(comment);
    }

    @Override
    public List<Comment> getCommentsByPostId(String postId) {

        return commentRepository.findAllByPostId(postId);
    }
}

