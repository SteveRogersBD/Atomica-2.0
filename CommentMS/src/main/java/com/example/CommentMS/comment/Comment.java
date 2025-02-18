package com.example.CommentMS.comment;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id", nullable = false,unique = true)
    private Long id;

    private String content;

    private LocalDateTime createdAt;

    @ElementCollection
    private List<String> images;

    @PrePersist
    protected void onCreate()
    {
        this.createdAt = LocalDateTime.now();
    }
}
