package ua.proxyband.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.proxyband.twitter.model.Comment;


@Repository
public interface CommentRepository extends MongoRepository<Comment, String> {
}
