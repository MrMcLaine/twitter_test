package ua.proxyband.twitter.service.impl;

import org.springframework.stereotype.Service;
import ua.proxyband.twitter.model.Post;
import ua.proxyband.twitter.repository.PostRepository;
import ua.proxyband.twitter.service.PostService;

@Service
class PostServiceImpl implements PostService {
    private final PostRepository postRepository;

    PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public Post createPost(Post post) {

        return postRepository.save(post);
    }

    @Override
    public Post updatePost(String postId, Post post) {
        Post existingPost = postRepository.findById(postId).orElse(null);
        if (existingPost != null) {

            existingPost.setContent(post.getContent());

            return postRepository.save(existingPost);
        }
        return null;
    }

    @Override
    public boolean deletePost(String postId) {
        Post existingPost = postRepository.findById(postId).orElse(null);
        if (existingPost != null) {
            postRepository.delete(existingPost);

            return true;
        }
        return false;
    }
}

