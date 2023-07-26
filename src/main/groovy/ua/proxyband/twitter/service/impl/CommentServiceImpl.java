package ua.proxyband.twitter.service.impl;

import org.springframework.stereotype.Service;
import ua.proxyband.twitter.model.Comment;
import ua.proxyband.twitter.repository.CommentRepository;
import ua.proxyband.twitter.service.CommentService;

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
}

