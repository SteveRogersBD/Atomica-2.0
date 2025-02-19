package com.example.Userms.clients;

import com.example.Userms.external.Comment;
import com.example.Userms.user.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="COMMENTMS",url="${commentms.service.url}")
public interface CommentClient {
    @GetMapping("/comment/user/{userId}")
    public ApiResponse<List<Comment>> getCommentsByUserId(@PathVariable Long userId);
}
