package com.example.CommentMS.comment;

import com.example.CommentMS.util.CommentNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class CommentService {

    @Autowired
    private CommentRepo commentRepo;

    @Transactional
    public Comment createComment(Comment comment) {
        return commentRepo.save(comment);
    }

    public Comment getById(Long id) {
        return commentRepo.findById(id)
                .orElseThrow(() -> new CommentNotFoundException("Comment not found with id: " + id));
    }

    public List<Comment> getAllComments() {
        return commentRepo.findAll();
    }

    @Transactional
    public Comment updateComment(Long id, Comment updatedComment) {
        Comment existingComment = getById(id);
        existingComment.setContent(updatedComment.getContent());
        existingComment.setImages(updatedComment.getImages());
        return commentRepo.save(existingComment);
    }

    @Transactional
    public void deleteComment(Long id) {
        Comment comment = getById(id);
        commentRepo.delete(comment);
    }

    public List<Comment> getCommentsByUserId(Long userId)
    {
        return commentRepo.findByUserId(userId);
    }

    public List<Comment> getCommentsByPostId(Long postId)
    {
        return commentRepo.findByPostId(postId);
    }

}

