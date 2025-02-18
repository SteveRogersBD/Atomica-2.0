package com.example.Userms.dto;

import com.example.Userms.user.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private Long id;
    private String username;
    private String email;
    private String password;
    private User.Role role;
    private String dp;
    private String about;
    private LocalDateTime createdAt;
    private List<PostDTO> comments;  // List of Comments
    private List<CommentDTO> reviews;    // List of Reviews

}
