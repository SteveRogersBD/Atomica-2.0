package com.example.PostMS.post;

import com.example.PostMS.util.PostNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepo postRepo;

    // Create a new post
    public Post createPost(Post post) {
        return postRepo.save(post);
    }

    // Get all posts
    public List<Post> getAllPosts() {
        return postRepo.findAll();
    }

    // Get a post by ID
    public Post getPostById(Long id) {
        Optional<Post> oPost = postRepo.findById(Math.toIntExact(id));
        if(oPost.isPresent())
        {
            return oPost.get();
        }
        throw new PostNotFoundException("Post not found with id " + id);
    }

    // Update a post
    public Post updatePost(Long id, Post updatedPost) {
        Post post = getPostById(id);
        post.setTitle(updatedPost.getTitle());
        post.setContent(updatedPost.getContent());
        post.setImages(updatedPost.getImages());
        return postRepo.save(post);
    }

    // Delete a post
    public Post deletePost(Long id) {
        Post post = getPostById(id);
        postRepo.delete(post);
        return post;
    }
}
