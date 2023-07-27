package ua.proxyband.twitter.service.impl;

import org.springframework.stereotype.Service;
import ua.proxyband.twitter.dto.PostWithDetails;
import ua.proxyband.twitter.dto.UserWithPostsDTO;
import ua.proxyband.twitter.model.Comment;
import ua.proxyband.twitter.model.Like;
import ua.proxyband.twitter.model.Post;
import ua.proxyband.twitter.model.User;
import ua.proxyband.twitter.repository.CommentRepository;
import ua.proxyband.twitter.repository.LikeRepository;
import ua.proxyband.twitter.repository.PostRepository;
import ua.proxyband.twitter.repository.UserRepository;
import ua.proxyband.twitter.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PostRepository postRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    public UserServiceImpl(
            UserRepository userRepository,
            PostRepository postRepository,
            LikeRepository likeRepository,
            CommentRepository commentRepository
    ) {
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.likeRepository = likeRepository;
        this.commentRepository = commentRepository;
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

    @Override
    public UserWithPostsDTO getUserWithPosts(String userId) {
        User user = userRepository.findById(userId).orElse(null);
        if (user == null) {
            return null;
        }

        List<Post> posts = postRepository.findAllByAuthorPostId(userId);

        List<Like> likes = likeRepository.findAllByAuthorPostId(userId);

        List<Comment> comments = commentRepository.findAllByAuthorPostId(userId);

        List<PostWithDetails> postsWithDetailsList = new ArrayList<>();

        for (Post post : posts) {
            PostWithDetails postWithDetails = new PostWithDetails();
            postWithDetails.setPost(post);

            List<Like> postLikes = likes.stream()
                    .filter(like -> like.getPostId().equals(post.getId()))
                    .collect(Collectors.toList());
            postWithDetails.setLikes(postLikes);

            List<Comment> postComments = comments.stream()
                    .filter(comment -> comment.getPostId().equals(post.getId()))
                    .collect(Collectors.toList());
            postWithDetails.setComments(postComments);

            postsWithDetailsList.add(postWithDetails);
        }

        UserWithPostsDTO userWithPostsDTO = new UserWithPostsDTO();
        userWithPostsDTO.setUserId(userId);
        userWithPostsDTO.setPosts(postsWithDetailsList);

        return userWithPostsDTO;
    }
}

