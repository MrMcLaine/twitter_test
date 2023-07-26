package ua.proxyband.twitter.service;

import ua.proxyband.twitter.model.Subscription;

public interface SubscriptionService {
    Subscription createSubscription(Subscription subscription);
    boolean deleteSubscription(String subscriptionId);
}
