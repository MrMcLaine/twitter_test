package ua.proxyband.twitter.service.impl;

import org.springframework.stereotype.Service;
import ua.proxyband.twitter.model.Subscription;
import ua.proxyband.twitter.repository.SubscriptionRepository;
import ua.proxyband.twitter.service.SubscriptionService;

@Service
class SubscriptionServiceImpl implements SubscriptionService {
    private final SubscriptionRepository subscriptionRepository;

    SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public Subscription createSubscription(Subscription subscription) {

        return subscriptionRepository.save(subscription);
    }

    @Override
    public boolean deleteSubscription(String subscriptionId) {
        Subscription existingSubscription = subscriptionRepository.findById(subscriptionId).orElse(null);
        if (existingSubscription != null) {
            subscriptionRepository.delete(existingSubscription);

            return true;
        }
        return false;
    }
}

