package com.example.CommentMS.comment;

import com.example.CommentMS.util.ApiResponse;
import com.example.CommentMS.util.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;

    @PostMapping
    public ApiResponse<Comment> createComment(@RequestBody Comment comment) {
        Comment createdComment = commentService.createComment(comment);
        return ApiResponse.onSuccess(Message.CREATED, createdComment);
    }

    @GetMapping("/{id}")
    public ApiResponse<Comment> getCommentById(@PathVariable Long id) {
        Comment comment = commentService.getById(id);
        return ApiResponse.onSuccess(Message.RETRIEVED, comment);
    }

    @GetMapping
    public ApiResponse<List<Comment>> getAllComments() {
        List<Comment> comments = commentService.getAllComments();
        return ApiResponse.onSuccess(Message.RETRIEVED, comments);
    }

    @PutMapping("/{id}")
    public ApiResponse<Comment> updateComment(@PathVariable Long id, @RequestBody Comment updatedComment) {
        Comment comment = commentService.updateComment(id, updatedComment);
        return ApiResponse.onSuccess(Message.UPDATED, comment);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Object> deleteComment(@PathVariable Long id) {
        commentService.deleteComment(id);
        return ApiResponse.onSuccess(Message.DELETED, null);
    }
}
