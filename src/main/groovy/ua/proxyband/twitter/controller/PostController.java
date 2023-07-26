package ua.proxyband.twitter.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.proxyband.twitter.model.Post;
import ua.proxyband.twitter.service.PostService;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping
    public ResponseEntity<Post> createPost(@RequestBody Post post) {
        Post createdPost = postService.createPost(post);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdPost);
    }

    @PutMapping("/{postId}")
    public ResponseEntity<Post> updatePost(@PathVariable String postId, @RequestBody Post post) {
        Post updatedPost = postService.updatePost(postId, post);
        if (updatedPost != null) {

            return ResponseEntity.ok(updatedPost);
        } else {

            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{postId}")
    public ResponseEntity<Void> deletePost(@PathVariable String postId) {
        boolean deleted = postService.deletePost(postId);
        if (deleted) {

            return ResponseEntity.noContent().build();
        } else {

            return ResponseEntity.notFound().build();
        }
    }
}
