package com.example.PostMS.clients;

import com.example.PostMS.external.Comment;
import com.example.PostMS.util.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="COMMENTMS",url="${commentms.service.url}")
public interface CommentClient {
    @GetMapping("/comment/post/{postId}")
    public ApiResponse<List<Comment>> getCommentsByPostId(@PathVariable Long postId);
}

