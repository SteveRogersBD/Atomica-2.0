package com.example.Userms.user;

import com.example.Userms.dto.PostDTO;
import com.example.Userms.util.Message;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    // CREATE - Create a new user
    @PostMapping
    public ApiResponse<User> createUser(@Valid @RequestBody User user) {
        User savedUser = userService.createUser(user);
        return ApiResponse.onSuccess(Message.CREATED, savedUser);
    }

    // READ - Get a user by ID
    @GetMapping("/{id}")
    public ApiResponse<User> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ApiResponse.onSuccess(Message.RETRIEVED,user);
    }

    // READ - Get all users
    @GetMapping
    public ApiResponse<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ApiResponse.onSuccess(Message.RETRIEVED,users);
    }

    // UPDATE - Update a user's information
    @PutMapping("/{id}")
    public ApiResponse<User> updateUser(@PathVariable Long id,
                                           @Valid @RequestBody User userDetails) {
        User updatedUser = userService.updateUser(id, userDetails);
        return ApiResponse.onSuccess(Message.UPDATED,updatedUser);
    }

    // DELETE - Delete a user by ID
    @DeleteMapping("/{id}")
    public ApiResponse<User> deleteUser(@PathVariable Long id) {
        User user = userService.deleteUser(id);
        return ApiResponse.onSuccess(Message.DELETED,user);
    }

    @GetMapping("/{id}/post")
    public ApiResponse<List<PostDTO>> getAllPostsByUser(@PathVariable("id") Long id) {
        List<PostDTO> posts = userService.getAllPosts(id);
        return ApiResponse.onSuccess(Message.RETRIEVED,posts);
    }
}
