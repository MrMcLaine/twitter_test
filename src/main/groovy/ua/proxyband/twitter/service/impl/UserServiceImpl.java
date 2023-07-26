package ua.proxyband.twitter.service.impl;

import org.springframework.stereotype.Service;
import ua.proxyband.twitter.model.User;
import ua.proxyband.twitter.repository.UserRepository;
import ua.proxyband.twitter.service.UserService;

@Service
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User createUser(User user) {

        return userRepository.save(user);
    }

    @Override
    public User updateUser(String userId, User user) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {

            existingUser.setEmail(user.getEmail());
            existingUser.setPassword(user.getPassword());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setBirthday(user.getBirthday());

            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public boolean deleteUser(String userId) {
        User existingUser = userRepository.findById(userId).orElse(null);
        if (existingUser != null) {
            userRepository.delete(existingUser);

            return true;
        }
        return false;
    }
}

