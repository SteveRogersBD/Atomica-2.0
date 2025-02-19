package com.example.Userms.user;

import com.example.Userms.clients.CommentClient;
import com.example.Userms.clients.PostClient;
import com.example.Userms.dto.CommentDTO;
import com.example.Userms.dto.PostDTO;
import com.example.Userms.external.Comment;
import com.example.Userms.external.Post;
import com.example.Userms.util.UserNotFoundException;
import com.netflix.discovery.converters.Auto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import mapper.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private PostClient postClient;

    @Autowired
    private CommentClient commentClient;


    // CREATE - Save a new user
    @Transactional
    public User createUser(User user) {
        return userRepo.save(user); // Save user using UserRepo
    }

    // READ - Get a user by ID
    public User getUserById(Long id) {
        Optional<User> user = userRepo.findById(id); // Fetch user by ID using UserRepo
        return user.orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    // READ - Get all users
    public List<User> getAllUsers() {
        return userRepo.findAll(); // Fetch all users using UserRepo
    }

    // UPDATE - Update a user's information
    @Transactional
    public User updateUser(Long id, User userDetails) {
        User user = getUserById(id);
        user.setUsername(userDetails.getUsername());
        user.setEmail(userDetails.getEmail());
        user.setPassword(userDetails.getPassword());
        user.setRole(userDetails.getRole());
        user.setDp(userDetails.getDp());
        user.setAbout(userDetails.getAbout());
        // Any other fields you want to update

        return userRepo.save(user); // Save the updated user using UserRepo
    }

    // DELETE - Delete a user by ID
    @Transactional
    public User deleteUser(Long id) {
        User user = getUserById(id);
        userRepo.delete(user); // Delete user using UserRepo
        return user;
    }

    public List<PostDTO> getAllPosts(Long id)
    {
        List<Post>posts = postClient.getAllPostsByUser(id).getData();
        List<PostDTO> postDTOs = new ArrayList<>();
        for (Post post : posts)
        {
            postDTOs.add(Mapper.toPostDTO(post));
        }
        return postDTOs;
    }

    public List<CommentDTO> getAllComments(Long id)
    {
        List<Comment>comments = commentClient.getCommentsByUserId(id).getData();
        List<CommentDTO> commentDTOS = new ArrayList<>();
        for (Comment comment : comments )
        {
            commentDTOS.add(Mapper.toCommentDTO(comment));
        }
        return commentDTOS;
    }
}
