package ua.proxyband.twitter.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import ua.proxyband.twitter.model.Subscription;


@Repository
public interface SubscriptionRepository extends MongoRepository<Subscription, String> {
}
