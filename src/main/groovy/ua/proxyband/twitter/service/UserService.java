package ua.proxyband.twitter.service;

import ua.proxyband.twitter.model.User;

public interface UserService {
    User createUser(User user);
    User updateUser(String userId, User user);
    boolean deleteUser(String userId);
}
