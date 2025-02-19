package com.example.CommentMS.comment;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long> {
    List<Comment>findByUserId(Long id);
    List<Comment>findByPostId(Long id);
}
