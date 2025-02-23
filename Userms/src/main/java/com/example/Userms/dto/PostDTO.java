package com.example.Userms.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostDTO {

    private Long id;

    private String title;

    private String content;

    private LocalDateTime createdAt;

    private List<String> images;
    private List<CommentDTO> comments;
}
