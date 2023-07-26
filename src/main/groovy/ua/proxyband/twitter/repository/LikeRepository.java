package ua.proxyband.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.proxyband.twitter.model.Like;


@Repository
public interface LikeRepository extends MongoRepository<Like, String> {
}
