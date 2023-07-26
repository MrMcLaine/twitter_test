package ua.proxyband.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.proxyband.twitter.model.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
}
