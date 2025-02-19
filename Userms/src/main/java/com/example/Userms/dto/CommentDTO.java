package com.example.Userms.dto;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

public class CommentDTO {

    private Long id;

    private String content;

    private LocalDateTime createdAt;

    private List<String> images;
}
