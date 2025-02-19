package com.example.Userms.clients;

import com.example.Userms.external.Post;
import com.example.Userms.user.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name="POSTMS",url="${postms.service.url}")
public interface PostClient {
    @GetMapping("/post/user/{id}")
    ApiResponse<List<Post>> getAllPostsByUser(@PathVariable("id") Long id);
}
