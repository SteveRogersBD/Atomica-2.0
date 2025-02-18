package com.example.PostMS.post;

import com.example.PostMS.util.ApiResponse;
import com.example.PostMS.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/post")
public class PostController {

    @Autowired
    private PostService postService;

    // Create a new post
    @PostMapping
    public ApiResponse<Post> createPost(@RequestBody Post post) {
        Post savedPost = postService.createPost(post);
        return ApiResponse.onSuccess(Message.CREATED, savedPost);
    }

    // Get all posts
    @GetMapping
    public ApiResponse<List<Post>> getAllPosts() {
        List<Post> posts = postService.getAllPosts();
        return ApiResponse.onSuccess(Message.RETRIEVED, posts);
    }

    // Get a single post by ID
    @GetMapping("/{id}")
    public ApiResponse<Post> getPostById(@PathVariable Long id) {
        Post post = postService.getPostById(id);
        return ApiResponse.onSuccess(Message.RETRIEVED, post);
    }

    // Update a post
    @PutMapping("/{id}")
    public ApiResponse<Post> updatePost(@PathVariable Long id, @RequestBody Post post) {
        Post uPost = postService.updatePost(id, post);
        return ApiResponse.onSuccess(Message.RETRIEVED, uPost);
    }

    // Delete a post
    @DeleteMapping("/{id}")
    public ApiResponse<Post> deletePost(@PathVariable Long id) {
        Post post = postService.deletePost(id);
        return ApiResponse.onSuccess(Message.DELETED, post);
    }
}
